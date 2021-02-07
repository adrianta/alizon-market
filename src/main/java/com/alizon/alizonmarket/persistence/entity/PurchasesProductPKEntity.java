package com.alizon.alizonmarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PurchasesProductPKEntity implements Serializable {

    @Column(name = "id_compra")
    private Integer purchaseId;

    @Column(name = "id_producto")
    private Integer productId;
}