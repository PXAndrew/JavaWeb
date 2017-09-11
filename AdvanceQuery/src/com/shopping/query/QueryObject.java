package com.shopping.query;

import java.util.*;

enum OrderBy {
    ASC,
    DESC
}

abstract public class QueryObject {

    // 高级查询参数
    private List<Object> paramters = new ArrayList<>();
    // 高级查询 sql 语句
    private List<String> conditions = new ArrayList<>();
    // 排序 map (有序) HashMap  无序，  LinkedHashMap 有序
    private Map<String, String> orderByMap = new LinkedHashMap<>();

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

        // 拼接排序 SQL
        if (orderByMap.size() > 0) {
            sqlString.append(" ORDER BY ");

            Set<Map.Entry<String, String>> entrySet = orderByMap.entrySet();
            for (Map.Entry<String, String> entry:
                    entrySet) {
                String columnName = entry.getKey();
                String orderBy = entry.getValue();
                sqlString.append(columnName).append(" ").append(orderBy).append(",");
            }
            sqlString.deleteCharAt(sqlString.length() - 1);

        }

        return sqlString.toString();
    }

    public List<Object> getParamters() {
        return paramters;
    }

    protected void addQuery(String condition, Object...paramter) {
        paramters.addAll(Arrays.asList(paramter));
        conditions.add("(" + condition + ")");
    }

    protected void addOrderBy(String columnName, OrderBy orderBy) {
        orderByMap.put(columnName, orderBy.name());
    }

    abstract protected void customizedQuery();
}
