package com.shopping.query;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductQueryObject {

    String name;
    BigDecimal minSalePrice;
    BigDecimal maxSalePrice;

}
