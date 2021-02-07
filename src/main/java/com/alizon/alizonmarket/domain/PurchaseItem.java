package com.alizon.alizonmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItem implements Serializable {

    private int productId;
    private int quantity;
    private BigDecimal total;
    private boolean active;
}
