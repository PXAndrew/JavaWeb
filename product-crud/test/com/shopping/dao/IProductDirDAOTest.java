package com.shopping.dao;

import com.shopping.dao.impl.ProductDirDAOImpl;
import com.shopping.domain.ProductDir;
import org.junit.Test;

import java.util.List;

public class IProductDirDAOTest {

    private IProductDirDAO productDirDAO = new ProductDirDAOImpl();

    @Test
    public void save() throws Exception {

        ProductDir productDir = new ProductDir();
        productDir.setDirName("美女鼠标");
        productDir.setParent_id(1L);
        productDirDAO.save(productDir);

    }

    @Test
    public void update() throws Exception {

        ProductDir productDir = productDirDAO.get(5L);
        productDir.setDirName("贱贱鼠标");
        productDirDAO.update(productDir);

    }

    @Test
    public void delete() throws Exception {
        productDirDAO.delete(5L);
    }

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