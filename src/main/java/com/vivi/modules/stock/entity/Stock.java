/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vivi.modules.stock.entity;

import com.vivi.modules.product.entity.Product;
import java.sql.Date;

/**
 *
 * @author wewezhu
 */
public class Stock {
    
    Product product;
    
    int inventory;
    
    Date effectiveStartDate;
    
    Date effectiveEndDate;
    
    
}
