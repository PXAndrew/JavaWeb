package com.shopping.query;

import java.util.List;

public interface IQuery {
    /*获取 sql 语句*/
    String getQuery();
    /*获取 参数*/
    List<Object> getParamters();
}
