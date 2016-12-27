/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spstudio.modules.sales.service.impl;

import com.spstudio.modules.member.dao.MemberAssetDAO;
import com.spstudio.modules.sales.dao.SaleDAO;
import com.spstudio.modules.sales.entity.Sales;
import com.spstudio.modules.sales.service.SaleService;

/**
 *
 * @author wewezhu
 */
public class SaleServiceImpl implements SaleService {
    private SaleDAO saleDAO;
    
    private MemberAssetDAO memberAssetDAO;

    public SaleDAO getSaleDAO() {
        return saleDAO;
    }

    public void setSaleDAO(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }

    @Override
    public Sales addSalesRecord(Sales sales) {
        Sales saleRec = saleDAO.addSalesRecord(sales);
        //Add MemberAsset
        memberAssetDAO.addMemeberDepositAsset(sales.getMember(), sales.getSalesCount());
        
        return saleRec;
    }
    
    
}
