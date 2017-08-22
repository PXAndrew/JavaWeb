package JDBC.student.Template;

import JDBC.student.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Template {

    public static void dmlUpdate(String sqlString, Object... params) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DruidUtil.createConnection();
            preparedStatement = connection.prepareStatement(sqlString);
            for (int index = 0; index < params.length; index++){
                preparedStatement.setObject(index + 1, params[index]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.closeConnection(connection, preparedStatement, null);
        }
    }

    public static <T> T dqlQuery(String sqlString, IResultsetHandler<T> resultsetHandler, Object... params) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DruidUtil.createConnection();
            preparedStatement = connection.prepareStatement(sqlString);
            for (int index = 0; index < params.length; index ++) {
                preparedStatement.setObject(index + 1, params[index]);
            }
            resultSet = preparedStatement.executeQuery();
            return resultsetHandler.handle(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.closeConnection(connection, preparedStatement, resultSet);
        }
        return null;

    }

}
