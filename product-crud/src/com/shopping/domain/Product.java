package com.shopping.domain;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class Product {

    private Long id;
    private String productName;
    private Long dir_id;
    private BigDecimal salePrice;
    private BigDecimal costPrice;
    private String supplier;
    private String brand;
    private Double cutoff;

}