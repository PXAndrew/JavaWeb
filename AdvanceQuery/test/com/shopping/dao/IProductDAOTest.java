package com.shopping.dao;

import com.shopping.dao.impl.ProductDAOImpl;
import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;

import java.util.List;

public class IProductDAOTest {

    private IProductDAO productDAO = new ProductDAOImpl();

    @org.junit.Test
    public void get() throws Exception {
        Product product = productDAO.get(1L);
        System.out.println(product);
    }

    @org.junit.Test
    public void list() throws Exception {
        List<Product> list = productDAO.list();
        for (Product product :
                list) {
            System.out.println(product);
        }
    }

}