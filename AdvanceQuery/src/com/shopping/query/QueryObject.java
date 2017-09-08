package com.shopping.query;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract public class QueryObject {

    private List<Object> paramters = new ArrayList<>();
    private List<String> conditions = new ArrayList<>();

    public String getQuery() {

        StringBuilder sqlString = new StringBuilder();

        customizedQuery();

        for (int i = 0; i < conditions.size(); i++) {
            if (i == 0) {
                sqlString.append(" WHERE ");
            } else {
                sqlString.append(" AND ");
            }
            sqlString.append(conditions.get(i));
        }

        return sqlString.toString();
    }

    public List<Object> getParamters() {
        return paramters;
    }

    protected void addQuery(String condition, Object paramter) {
        paramters.add(paramter);
        conditions.add(condition);
    }

    abstract protected void customizedQuery();
}
