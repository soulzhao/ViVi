/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vivi.modules.sales.dao.impl;

import com.vivi.modules.sales.dao.SaleDAO;
import org.hibernate.SessionFactory;

/**
 *
 * @author wewezhu
 */
public class SaleDAOImpl implements SaleDAO{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
}
