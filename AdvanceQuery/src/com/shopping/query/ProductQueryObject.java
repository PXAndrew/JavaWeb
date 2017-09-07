package com.shopping.query;

import com.shopping.util.StringUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductQueryObject implements IQuery {

    String name;
    BigDecimal minSalePrice;
    BigDecimal maxSalePrice;

    private List<Object> paramters = new ArrayList<>();
    private List<String> condition = new ArrayList<>();

    @Override
    public String getQuery() {

        StringBuilder sqlString = new StringBuilder();

        if (StringUtil.hasLength(name)) {
            paramters.add("%" + name + "%");
            condition.add("productName LIKE ?");
        }

        if (minSalePrice != null) {
            paramters.add(minSalePrice);
            condition.add("salePrice >= ?");
        }

        if (maxSalePrice != null) {
            paramters.add(maxSalePrice);
            condition.add("salePrice <= ?");
        }

        for (int i = 0; i < condition.size(); i++) {
            if (i == 0) {
                sqlString.append(" WHERE ");
            } else {
                sqlString.append(" AND ");
            }
            sqlString.append(condition.get(i));
        }

        return sqlString.toString();
    }

    @Override
    public List<Object> getParamters() {
        return paramters;
    }

}
