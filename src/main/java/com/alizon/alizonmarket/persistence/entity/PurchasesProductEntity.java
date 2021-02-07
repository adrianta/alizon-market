package com.alizon.alizonmarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
public class PurchasesProductEntity {

    @EmbeddedId
    private PurchasesProductPKEntity id;

    @Column(name = "cantidad")
    private Integer quantity;

    private BigDecimal total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private ProductEntity product;
}
