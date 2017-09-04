package com.shopping.template;

import com.shopping.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

    private JdbcTemplate() {}

    public static int dml(String sqlString, Object... params) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sqlString);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, null);
        }
        return 0;
    }

    public static <T> List<T> dql(String sqlString, IResultSetHandler<T> resultSetHandler, Object... params) {

        List<T> list = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 从 java 6 开始可以不加载驱动，但是在 JavaEE 中 一定要加载驱动
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sqlString);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
            list = resultSetHandler.handle(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, resultSet);
        }
        return list;

    }

}
