package com.shopping.dao;

import com.shopping.dao.impl.ProductDAOImpl;
import com.shopping.domain.Product;

import java.util.List;

public class IProductDAOTest {

    private IProductDAO productDAO = new ProductDAOImpl();

    @org.junit.Test
    public void save() throws Exception {
        Product product = new Product();
        product.setProductName("jiaojian");
        product.setDir_id(3L);
        product.setCutoff(0.6);
        productDAO.save(product);

    }

    @org.junit.Test
    public void update() throws Exception {

        Product product = productDAO.get(24L);
        product.setProductName("jiaojian");
        productDAO.update(product);
    }

    @org.junit.Test
    public void delete() throws Exception {
        productDAO.delete(25L);

    }

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