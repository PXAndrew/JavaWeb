package com.shopping.dao;

import com.shopping.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IProductDAO {

    Product get(Long id);

    List<Product> list();

    /**
     * 高级查询
     * @param name          商品名称，做模糊查询
     * @param minSalePrice  商品的最低价格
     * @param maxSalePrice  商品的最高价格
     * @return              符合条件的结果集
     */
    List<Product> query(String name, BigDecimal minSalePrice, BigDecimal maxSalePrice);
    
}
