package com.alizon.alizonmarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer ProductId;

    @Column(name = "nombre", length = 45)
    private String name;

    @Column(name = "id_categoria")
    private Integer categoryId;

    @Column(name = "codigo_barras", length = 150)
    private String barCode;

    @Column(name = "precio_venta")
    private BigDecimal salePrice;

    @Column(name = "cantidad_stock")
    private Integer stockQuantity;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private CategoryEntity category;
}
