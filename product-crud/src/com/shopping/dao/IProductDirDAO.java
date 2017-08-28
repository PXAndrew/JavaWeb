package com.shopping.dao;

import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;

import java.util.List;

public interface IProductDirDAO {

    void save(ProductDir obj);

    void update(ProductDir obj);

    void delete(Long id);

    ProductDir get(Long id);

    List<ProductDir> list();
    
}
