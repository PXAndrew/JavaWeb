package com.shopping.dao;

import com.shopping.dao.impl.ProductDirDAOImpl;
import com.shopping.domain.ProductDir;
import org.junit.Test;

import java.util.List;

public class IProductDirDAOTest {

    private IProductDirDAO productDirDAO = new ProductDirDAOImpl();

    @Test
    public void get() throws Exception {

        ProductDir productDir = productDirDAO.get(2L);
        System.out.println(productDir);
    }

    @Test
    public void list() throws Exception {
        List<ProductDir> list = productDirDAO.list();
        System.out.println(list);
    }

}