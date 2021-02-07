package com.alizon.alizonmarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class CustomerEntity {

    @Id
    private String id;

    @Column(name = "nombre", length = 40)
    private String name;
    @Column(name = "apellidos", length = 100)
    private String lastName;
    @Column(name = "celular")
    private Long telephone;
    @Column(name = "correo_electronico", length = 70)
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<PurchaseEntity> purchases;
}
