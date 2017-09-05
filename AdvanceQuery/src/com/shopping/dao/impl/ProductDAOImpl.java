package com.shopping.dao.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.shopping.dao.IProductDAO;
import com.shopping.dao.IProductDirDAO;
import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;
import com.shopping.template.IResultSetHandler;
import com.shopping.template.JdbcTemplate;
import com.shopping.util.JdbcUtil;
import com.shopping.util.StringUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements IProductDAO {

    IResultSetHandler resultSetHandler = new ProductResultSetHandler();

    @Override
    public Product get(Long id) {
        String sqlString = "SELECT * FROM product WHERE id = ?";
        List<Product> list = JdbcTemplate.dql(sqlString, resultSetHandler, id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Product> list() {

        String sqlString = "SELECT * FROM product";
        return JdbcTemplate.dql(sqlString, new ProductResultSetHandler());

    }

    @Override
    public List<Product> query(String name, BigDecimal minSalePrice, BigDecimal maxSalePrice) {

        StringBuilder sqlString = new StringBuilder("SELECT * FROM product WHERE 1 = 1");
        List params = new ArrayList();

        if (StringUtil.hasLength(name)) {
            params.add("%" + name + "%");
            sqlString.append(" AND productName LIKE ?");
        }

        if (minSalePrice != null) {
            params.add(minSalePrice);
            sqlString.append(" AND salePrice >= ?");
        }

        if (maxSalePrice != null) {
            params.add(maxSalePrice);
            sqlString.append(" AND salePrice <= ?");
        }

        return JdbcTemplate.dql(sqlString.toString(), resultSetHandler, params.toArray());
    }


    class ProductResultSetHandler implements IResultSetHandler<Product> {

        @Override
        public List<Product> handle(ResultSet resultSet) throws SQLException {
            Map<Long, ProductDir> cache = new HashMap<>();
            IProductDirDAO productDirDAO = new ProductDirDAOImpl();
            List<Product> list = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setProductName(resultSet.getString("productName"));
                product.setBrand(resultSet.getString("brand"));
                product.setCostPrice(resultSet.getBigDecimal("costPrice"));
                product.setCutoff(resultSet.getDouble("cutoff"));
                product.setSalePrice(resultSet.getBigDecimal("salePrice"));
                product.setSupplier(resultSet.getString("supplier"));
                Long dir_id = resultSet.getLong("dir_id");
                ProductDir productDir = cache.get(dir_id);
                if (productDir == null) {
                    productDir = productDirDAO.get(dir_id);
                    cache.put(dir_id, productDir);
                }
                product.setProductDir(productDir);
                list.add(product);
            }
            return list;
        }
    }

}
