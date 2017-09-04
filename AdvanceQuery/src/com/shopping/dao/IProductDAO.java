package com.shopping.dao;

import com.shopping.domain.Product;
import java.util.List;

public interface IProductDAO {

    Product get(Long id);

    List<Product> list();
    
}
