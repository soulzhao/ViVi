package com.spstudio.modules.product.bean.request;

import com.spstudio.modules.product.entity.Product;
import com.spstudio.modules.product.entity.ProductType;
import com.spstudio.modules.product.service.ProductService;

/**
 * Created by Soul on 2017/1/1.
 */
public class ProductJsonBeanUtil {
    public static ProductJsonBean toJsonBean(Product product) {
        if(product == null) return null;

        ProductJsonBean jsonBean = new ProductJsonBean();

        jsonBean.setProduct_id(product.getProductId());
        jsonBean.setProduct_serialno(product.getSerialno());
        jsonBean.setProduct_uom(product.getUom());
        jsonBean.setProduct_type(product.getType().getTypeName());
        jsonBean.setProduct_price(String.valueOf(product.getUnitPrice()));
        jsonBean.setProduct_name(product.getProductName());
        jsonBean.setProduct_description(product.getDescription());
        jsonBean.setProduct_create_date(product.getCreationDate().toString());
        jsonBean.setProduct_available(product.isAvailable());
        jsonBean.setProduct_unitBonus(product.getBonusePoint());

        return jsonBean;
    }

    public static Product toEntityBean(ProductJsonBean productJsonBean, ProductService service){
        Product product = new Product();
        try {
            product.setUnitPrice(Float.valueOf(productJsonBean.getProduct_price()));
        }catch (NumberFormatException ex){
            return null;
        }

        product.setSerialno(productJsonBean.getProduct_serialno());
        product.setProductName(productJsonBean.getProduct_name());
        product.setUom(productJsonBean.getProduct_uom());
        product.setDescription(productJsonBean.getProduct_description());
        product.setAvailable(productJsonBean.isProduct_available());
        product.setBonusePoint(productJsonBean.getProduct_unitBonus());

        String productType = productJsonBean.getProduct_type();
        if(!productType.isEmpty()){
            ProductType productTypeEO = service.findProductTypeByProductTypeName(productType);
            if(productTypeEO != null)
                product.setType(productTypeEO);
            else
                product.setType(service.findProductTypeByProductTypeName("default"));
        }else {
            product.setType(service.findProductTypeByProductTypeName("default"));
        }

        return product;
    }
}
