package com.alizon.alizonmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable {

    private int purchaseId;
    private String customerId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;
}
