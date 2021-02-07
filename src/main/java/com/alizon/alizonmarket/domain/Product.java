package com.alizon.alizonmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private int productId;
    private String name;
    private int categoryId;
    private BigDecimal price;
    private int stock;
    private boolean active;
    private Category category;
}
