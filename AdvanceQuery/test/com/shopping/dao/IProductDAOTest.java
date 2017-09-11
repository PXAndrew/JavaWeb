package com.shopping.dao;

import com.shopping.dao.impl.ProductDAOImpl;
import com.shopping.domain.Product;
import com.shopping.query.ProductQueryObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class IProductDAOTest {

    private IProductDAO productDAO = new ProductDAOImpl();

    @Test
    public void get() throws Exception {
        Product product = productDAO.get(1L);
        System.out.println(product);
    }

    @Test
    public void list() throws Exception {
        List<Product> list = productDAO.list();
        for (Product product :
                list) {
            System.out.println(product);
        }
    }

    @Test
    public void query2() throws Exception {

        List<Product> list = productDAO.query2("M", new BigDecimal(150), new BigDecimal(300));
        System.out.println(list.size());
        for (Product product :
                list) {
            System.out.println(product);
        }
    }

    @Test
    public void query3() throws Exception {
        ProductQueryObject productQueryObject = new ProductQueryObject();
        productQueryObject.setName("M");
        productQueryObject.setMinSalePrice(new BigDecimal(150));
        productQueryObject.setMaxSalePrice(new BigDecimal(300));
        List<Product> list = productDAO.query3(productQueryObject);
        System.out.println(list.size());
        for (Product product :
                list) {
            System.out.println(product);
        }
    }

    @Test
    public void query4() throws Exception {
        ProductQueryObject productQueryObject = new ProductQueryObject();
        productQueryObject.setName("M");
        productQueryObject.setMinSalePrice(new BigDecimal(1));
        productQueryObject.setMaxSalePrice(new BigDecimal(500));
        List<Product> list = productDAO.query4(productQueryObject);
        System.out.println(list.size());
        for (Product product :
                list) {
            System.out.println(product);
        }
    }
}