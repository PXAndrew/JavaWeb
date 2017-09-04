package com.shopping.dao.impl;

import com.shopping.dao.IProductDAO;
import com.shopping.dao.IProductDirDAO;
import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;
import com.shopping.template.IResultSetHandler;
import com.shopping.template.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDirDAOImpl implements IProductDirDAO {

    @Override
    public ProductDir get(Long id) {
        String sqlString = "SELECT * FROM productdir WHERE id = ?";
        List<ProductDir> list = JdbcTemplate.dql(sqlString, new ProductDirResultSetHandler(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<ProductDir> list() {
        String sqlString = "SELECT * FROM productdir";
        return JdbcTemplate.dql(sqlString, new ProductDirResultSetHandler());
    }

    class ProductDirResultSetHandler implements IResultSetHandler<ProductDir> {

        @Override
        public List<ProductDir> handle(ResultSet resultSet) throws SQLException {

            List<ProductDir> list = new ArrayList<>();

            while (resultSet.next()) {
                ProductDir productDir = new ProductDir();
                productDir.setId(resultSet.getLong("id"));
                productDir.setDirName(resultSet.getString("dirName"));
                productDir.setParent_id(resultSet.getLong("parent_id"));
                list.add(productDir);
            }

            return list;
        }
    }
}
