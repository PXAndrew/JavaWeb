package com.shopping.dao.impl;

import com.shopping.dao.IProductDAO;
import com.shopping.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    @Override
    public void save(Product product) {

        String sqlString = "INSERT INTO product(productName, dir_id, salePrice, supplier, brand, cutoff, costPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo");
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getDir_id());
            preparedStatement.setBigDecimal(3, product.getSalePrice());
            preparedStatement.setString(4, product.getSupplier());
            preparedStatement.setString(5, product.getBrand());
             preparedStatement.setDouble(6, product.getCutoff());
            preparedStatement.setBigDecimal(7, product.getCostPrice());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void update(Product product) {
        String sqlString = "UPDATE product SET productName=?, dir_id=?, salePrice=?, supplier=?, brand=?, cutoff=?, costPrice=? WHERE id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo");
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2, product.getDir_id());
            preparedStatement.setBigDecimal(3, product.getSalePrice());
            preparedStatement.setString(4, product.getSupplier());
            preparedStatement.setString(5, product.getBrand());
            preparedStatement.setDouble(6, product.getCutoff());
            preparedStatement.setBigDecimal(7, product.getCostPrice());
            preparedStatement.setLong(8, product.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Long id) {
        String sqlString = "DELETE FROM product WHERE id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo");
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Product get(Long id) {
        String sqlString = "SELECT * FROM product WHERE id = ?";

        Product product = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 从 java 6 开始可以不加载驱动，但是在 JavaEE 中 一定要加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo", "root", "1Csandrew");
            preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setProductName(resultSet.getString("productName"));
                product.setBrand(resultSet.getString("brand"));
                product.setCostPrice(resultSet.getBigDecimal("costPrice"));
                product.setCutoff(resultSet.getDouble("cutoff"));
                product.setDir_id(resultSet.getLong("dir_id"));
                product.setSalePrice(resultSet.getBigDecimal("salePrice"));
                product.setSupplier(resultSet.getString("supplier"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return product;
    }

    @Override
    public List<Product> list() {
        String sqlString = "SELECT * FROM product";

        List<Product> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 从 java 6 开始可以不加载驱动，但是在 JavaEE 中 一定要加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbcdemo", "root", "1Csandrew");
            preparedStatement = connection.prepareStatement(sqlString);
            resultSet = preparedStatement.executeQuery();
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

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }
}
