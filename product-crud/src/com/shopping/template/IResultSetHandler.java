package com.shopping.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IResultSetHandler<T> {

    public List<T> handle(ResultSet resultSet) throws SQLException;

}
