package com.alizon.alizonmarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
@Getter
@Setter
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer purchaseId;

    @Column(name = "id_cliente")
    private String customerId;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago", length = 1)
    private String paymentMethod;

    @Column(name = "comentario", length = 300)
    private String comment;

    @Column(name = "estado", length = 1)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    private List<PurchasesProductEntity> products;
}
