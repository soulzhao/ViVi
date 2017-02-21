package com.spstudio.modules.workorder.controller;

import com.spstudio.common.response.ResponseBean;
import com.spstudio.common.response.ResponseMsgBeanFactory;
import com.spstudio.common.search.Page;
import com.spstudio.common.search.SearchConditionEnum;
import com.spstudio.common.search.SearchCriteria;
import com.spstudio.common.search.SearchCriteriaItem;
import com.spstudio.common.utils.DateUtils;
import com.spstudio.modules.member.service.MemberService;
import com.spstudio.modules.product.service.ProductService;
import com.spstudio.modules.sp.service.ServiceProviderService;
import com.spstudio.modules.workorder.bean.WorkOrderConfirmJsonBean;
import com.spstudio.modules.workorder.bean.WorkOrderJsonBean;
import com.spstudio.modules.workorder.bean.WorkOrderJsonBeanUtil;
import com.spstudio.modules.workorder.entity.WorkOrder;
import com.spstudio.modules.workorder.service.WorkOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Soul on 2017/2/13.
 */
@RestController
@RequestMapping("/workorder")
public class WorkOrderController {
    @Resource(name="serviceProviderService")
    private ServiceProviderService serviceProviderService;

    @Resource(name="memberService")
    private MemberService memberService;

    @Resource(name="productService")
    private ProductService productService;

    @Resource(name="workOrderService")
    private WorkOrderService workOrderService;

    private final static Map<String, String> errorMap =
            new HashMap<String, String>(){
                {
                    put("7001",  "日期格式错误");
                    put("7002",  "未能找到该工单，工单Id: %s");
                    put("7003",  "工单（%s）取消失败");
                }
            };

    public ServiceProviderService getServiceProviderService() {
        return serviceProviderService;
    }

    public void setServiceProviderService(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public WorkOrderService getWorkOrderService() {
        return workOrderService;
    }

    public void setWorkOrderService(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @RequestMapping(value = "/add_workorder",
            method = RequestMethod.PUT,
            headers="Accept=application/json")
    @CrossOrigin
    public @ResponseBody ResponseBean addWorkOrder(
            @RequestBody WorkOrderJsonBean workOrderJsonBean){
        try {
            WorkOrder workOrder = WorkOrderJsonBeanUtil.toEntityBean(
                    workOrderJsonBean,
                    serviceProviderService,
                    memberService,
                    productService
                    );

            workOrderService.addWorkOrder(workOrder);

            return ResponseMsgBeanFactory.getSuccessResponseBean(
                    "工单创建成功！"
            );
        } catch (ParseException e) {
            // Confirm Date parse error
            return ResponseMsgBeanFactory.getErrorResponseBean(
                    "7001",
                    errorMap.get("7001")
            );
        }
    }

    @RequestMapping(value = "/confirm_workorder/{workorder_id}",
            method = RequestMethod.POST,
            headers="Accept=application/json")
    @CrossOrigin
    public @ResponseBody ResponseBean confirmWorkOrder(
            @PathVariable String workorder_id,
            @RequestBody WorkOrderConfirmJsonBean confirmJsonBean){
        WorkOrder workOrder =
                workOrderService.confirmWorkOrder(
                        workorder_id,
                        confirmJsonBean.getRate(),
                        confirmJsonBean.getNote()
                );
        if(workOrder == null){
            return ResponseMsgBeanFactory.getErrorResponseBean(
                    "7002",
                    String.format(errorMap.get("7002"), workorder_id)
            );
        }else{
            return ResponseMsgBeanFactory.getSuccessResponseBean(
                    "订单确认成功！"
            );
        }
    }

    @RequestMapping(value = "/cancel_workorder/{workorder_id}",
            method = RequestMethod.DELETE,
            headers="Accept=application/json")
    @CrossOrigin
    public @ResponseBody ResponseBean cancelWorkOrder(@PathVariable String workorder_id){
        WorkOrder workOrder =
                workOrderService.findWorkOrderByWordOrderId(workorder_id);
        if(workOrder == null){
            return ResponseMsgBeanFactory.getErrorResponseBean(
                "7002",
                String.format(errorMap.get("7002"), workorder_id)
            );
        }
        if(workOrderService.cancelWorkOrder(workOrder)){
            return ResponseMsgBeanFactory.getSuccessResponseBean(
                "工单取消成功!"
            );
        }else{
            return ResponseMsgBeanFactory.getErrorResponseBean(
                "7003",
                String.format(errorMap.get("7003"), workorder_id)
            );
        }
    }

    @RequestMapping(value = "/list_workorders",
            method = RequestMethod.GET,
            headers="Accept=application/json")
    @CrossOrigin
    public @ResponseBody
    ResponseBean listWorkOrders(@RequestParam(value="page", required=true) int page,
                                @RequestParam(value="page_size", required=true) int page_size,
                                @RequestParam(value="employee_id", required=false) String employee_id,
                                @RequestParam(value="member_id", required=false) String member_id,
                                @RequestParam(value="start_date", required=false) String start_date,
                                @RequestParam(value="end_date", required=false) String end_date,
                                @RequestParam(value="confirm_start_date", required=false) String confirm_start_date,
                                @RequestParam(value="confirm_end_date", required=false) String confirm_end_date){
        SearchCriteria sc = new SearchCriteria();

        if(member_id!= null &&
                !member_id.isEmpty())
            sc.addSearchCriterialItem("member_id",
                    new SearchCriteriaItem("member_id", member_id, SearchConditionEnum.Equal)
            );

        if(employee_id!= null &&
                !employee_id.isEmpty())
            sc.addSearchCriterialItem("employee_id",
                    new SearchCriteriaItem("employee_id", employee_id, SearchConditionEnum.Equal)
            );

        Page<WorkOrder> resultPageBean = workOrderService.queryForPage(page, page_size, sc);

        List<WorkOrderJsonBean> workorderListJsonBean = new ArrayList<WorkOrderJsonBean>();
        for (WorkOrder workOrder: resultPageBean.getList()){
             workorderListJsonBean.add(WorkOrderJsonBeanUtil.toJsonBean(workOrder));
        }

        Page<WorkOrderJsonBean> returnPage = new Page<WorkOrderJsonBean>();

        returnPage.setTotalRecords(resultPageBean.getTotalRecords());
        returnPage.setPageNo(resultPageBean.getPageNo());
        returnPage.setPageSize(resultPageBean.getPageSize());

        returnPage.setList(workorderListJsonBean);

        return ResponseMsgBeanFactory.getResponseBean(
                true,
                returnPage
        );
    }
}
