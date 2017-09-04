package com.shopping.dao;

import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;

import java.util.List;

public interface IProductDirDAO {

    ProductDir get(Long id);

    List<ProductDir> list();
    
}
