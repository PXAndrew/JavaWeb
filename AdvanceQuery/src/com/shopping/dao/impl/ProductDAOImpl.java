package com.shopping.dao.impl;

import com.shopping.dao.IProductDAO;
import com.shopping.dao.IProductDirDAO;
import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;
import com.shopping.query.ProductQueryObject;
import com.shopping.template.IResultSetHandler;
import com.shopping.template.JdbcTemplate;
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
    public List<Product> query1(String name, BigDecimal minSalePrice, BigDecimal maxSalePrice) {

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

    /**
     * 我们使用了 WHERE 1=1 其他条件全部用 AND 来链接
     * 这本身没有什么问题，但是使用 WHERE 1=1 之后，就不能使用索引了。从 MYSQL 5.7 开始，会自动默认取消掉 SQL 中第一个为 true 的条件
     * @param name
     * @param minSalePrice
     * @param maxSalePrice
     * @return
     */
    @Override
    public List<Product> query2(String name, BigDecimal minSalePrice, BigDecimal maxSalePrice) {

        StringBuilder sqlString = new StringBuilder("SELECT * FROM product");
        List params = new ArrayList();

        boolean isFirst = true;
        if (StringUtil.hasLength(name)) {
            if (isFirst) {
                sqlString.append(" WHERE ");
                isFirst = false;
            } else {
                sqlString.append(" AND ");
            }
            params.add("%" + name + "%");
            sqlString.append("productName LIKE ?");
        }

        if (minSalePrice != null) {
            if (isFirst) {
                sqlString.append(" WHERE ");
                isFirst = false;
            } else {
                sqlString.append(" AND ");
            }
            params.add(minSalePrice);
            sqlString.append("salePrice >= ?");
        }

        if (maxSalePrice != null) {
            if (isFirst) {
                sqlString.append(" WHERE ");
                isFirst = false;
            } else {
                sqlString.append(" AND ");
            }
            params.add(maxSalePrice);
            sqlString.append("salePrice <= ?");
        }

        return JdbcTemplate.dql(sqlString.toString(), resultSetHandler, params.toArray());
    }

    @Override
    public List<Product> query3(ProductQueryObject productQueryObject) {
        StringBuilder sqlString = new StringBuilder("SELECT * FROM product");
        List params = new ArrayList();

        boolean isFirst = true;
        if (StringUtil.hasLength(productQueryObject.getName())) {
            if (isFirst) {
                sqlString.append(" WHERE ");
                isFirst = false;
            } else {
                sqlString.append(" AND ");
            }
            params.add("%" + productQueryObject.getName() + "%");
            sqlString.append("productName LIKE ?");
        }

        if (productQueryObject.getMinSalePrice() != null) {
            if (isFirst) {
                sqlString.append(" WHERE ");
                isFirst = false;
            } else {
                sqlString.append(" AND ");
            }
            params.add(productQueryObject.getMinSalePrice());
            sqlString.append("salePrice >= ?");
        }

        if (productQueryObject.getMaxSalePrice() != null) {
            if (isFirst) {
                sqlString.append(" WHERE ");
                isFirst = false;
            } else {
                sqlString.append(" AND ");
            }
            params.add(productQueryObject.getMaxSalePrice());
            sqlString.append("salePrice <= ?");
        }

        return JdbcTemplate.dql(sqlString.toString(), resultSetHandler, params.toArray());
    }

    @Override
    public List<Product> query4(ProductQueryObject productQueryObject) {
        String sqlString = "SELECT * FROM product" + productQueryObject.getQuery();
        List<Object> paramters = productQueryObject.getParamters();
        return JdbcTemplate.dql(sqlString, resultSetHandler, paramters.toArray());
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
