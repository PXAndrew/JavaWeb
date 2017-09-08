package com.shopping.query;

import com.shopping.util.StringUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductQueryObject extends QueryObject {

    String name;
    BigDecimal minSalePrice;
    BigDecimal maxSalePrice;

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
    }
}
