package com.shopping.query;

import com.shopping.util.StringUtil;
import com.sun.tools.corba.se.idl.constExpr.Or;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductQueryObject extends QueryObject {

    String name;
    BigDecimal minSalePrice;
    BigDecimal maxSalePrice;
    Long dirID;
    String keyword;

    @Override
    protected void customizedQuery() {
        if (StringUtil.hasLength(name)) {
            addQuery("productName LIKE ?", "%" + name + "%");
        }

        if (minSalePrice != null) {
            addQuery("salePrice >= ?", minSalePrice);
        }

        if (maxSalePrice != null) {
            addQuery("salePrice <= ?", maxSalePrice);
        }

        if (dirID != null && dirID != -1) {
            addQuery("dir_id = ?", dirID);
        }

        if (StringUtil.hasLength(keyword)) {
            addQuery("productName LIKE ? OR brand LIKE ?", "%" + keyword + "%", "%" + keyword + "%");
        }

        addOrderBy("dir_id", OrderBy.ASC);
        addOrderBy("salePrice", OrderBy.DESC);
    }
}
