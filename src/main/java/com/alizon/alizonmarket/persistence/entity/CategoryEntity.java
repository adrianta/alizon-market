package com.alizon.alizonmarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer categoryId;

    @Column(name = "descripcion", length = 45)
    private String description;

    @Column(name = "estado")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;
}
