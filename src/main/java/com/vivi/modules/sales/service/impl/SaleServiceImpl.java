/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vivi.modules.sales.service.impl;

import com.vivi.modules.sales.dao.SaleDAO;
import com.vivi.modules.sales.service.SaleService;

/**
 *
 * @author wewezhu
 */
public class SaleServiceImpl implements SaleService{
    private SaleDAO saleDAO;

    public SaleDAO getSaleDAO() {
        return saleDAO;
    }

    public void setSaleDAO(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }
    
    
}
