/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spstudio.common.search;

import java.util.List;

/**
 *
 * @author wewezhu
 */
public class Page<E> {
    // 结果集
    private List<E> list;

    // 查询记录总数
    private int totalRecords;

    // 每页多少条记录
    private int pageSize;

    // 第几页
    private int pageNo;
    
    /**
     * @return 总页数
     * */
    public int getTotalPages(){
        return (totalRecords + pageSize) / pageSize;
    }
    
    /**
     * 计算当前页开始记录
     * @param pageSize 每页记录数
     * @param currentPage 当前第几页
     * @return 当前页开始记录号
     */
    public int countOffset(int currentPage,int pageSize){
        int offset = pageSize*(currentPage-1);
        return offset;
    }
    
    /**
     * @return 首页
     * */
    public int getTopPageNo(){
        if(totalRecords == 0)
            return 0;

        return 1;
    }
    
    /**
     * @return 上一页
     * */
    public int getPreviousPageNo(){
        if(totalRecords == 0)
            return 0;

        if(pageNo <= 1){
            return 1;
        }
        return pageNo - 1;
    }
    
    /**
     * @return 下一页
     * */
    public int getNextPageNo(){

        if(pageNo >= getBottomPageNo()){
            return getBottomPageNo();
        }
        return pageNo + 1;
    }
    
    /**
     * @return 尾页
     * */
    public int getBottomPageNo(){
        return getTotalPages();
    }
    
    
    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        System.out.println("SetPageSize:"+pageSize);
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
