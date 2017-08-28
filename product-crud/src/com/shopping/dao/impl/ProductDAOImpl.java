package com.shopping.dao.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.shopping.dao.IProductDAO;
import com.shopping.domain.Product;
import com.shopping.template.IResultSetHandler;
import com.shopping.template.JdbcTemplate;
import com.shopping.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDAOImpl implements IProductDAO {

    @Override
    public void save(Product obj) {
        String sqlString = "INSERT INTO product(productName, dir_id, salePrice, supplier, brand, cutoff, costPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcTemplate.dml(sqlString, obj.getProductName(), obj.getDir_id(), obj.getSalePrice(), obj.getSupplier(), obj.getBrand(), obj.getCutoff(), obj.getCostPrice());
    }

    @Override
    public void update(Product obj) {
        String sqlString = "UPDATE product SET productName=?, dir_id=?, salePrice=?, supplier=?, brand=?, cutoff=?, costPrice=? WHERE id=?";
        JdbcTemplate.dml(sqlString, obj.getProductName(), obj.getDir_id(), obj.getSalePrice(), obj.getSupplier(), obj.getBrand(), obj.getCutoff(), obj.getCostPrice(), obj.getId());
    }

    @Override
    public void delete(Long id) {
        String sqlString = "DELETE FROM product WHERE id=?";
        JdbcTemplate.dml(sqlString, id);
    }

    @Override
    public Product get(Long id) {
        String sqlString = "SELECT * FROM product WHERE id = ?";
        List<Product> list = JdbcTemplate.dql(sqlString, new ProductResultSetHandler(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Product> list() {

        String sqlString = "SELECT * FROM product";
        return JdbcTemplate.dql(sqlString, new ProductResultSetHandler());

    }


    class ProductResultSetHandler implements IResultSetHandler<Product> {

        @Override
        public List<Product> handle(ResultSet resultSet) throws SQLException {
            List<Product> list = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setProductName(resultSet.getString("productName"));
                product.setBrand(resultSet.getString("brand"));
                product.setCostPrice(resultSet.getBigDecimal("costPrice"));
                product.setCutoff(resultSet.getDouble("cutoff"));
                product.setDir_id(resultSet.getLong("dir_id"));
                product.setSalePrice(resultSet.getBigDecimal("salePrice"));
                product.setSupplier(resultSet.getString("supplier"));
                list.add(product);
            }
            return list;
        }
    }

}
