package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prodId;

    @Column(name = "prod_name", nullable = false, unique = true)
    private String prodName;

    @Column(name = "prod_price", nullable = false)
    private BigDecimal prodPrice;

    @Column(name = "prod_desc", nullable = false)
    private String prodDesc;

    @Column(name = "has_milk", nullable = false)
    private Boolean hasMilk;

    @Column(name = "has_cream", nullable = false)
    private Boolean hasCream;

    @Column(name = "has_sugar", nullable = false)
    private Boolean hasSugar;

    @Column(name = "has_condiments", nullable = false)
    private Boolean hasCondiments;

    @OneToMany(mappedBy = "product")
    private List<ItemEntity> items;

    @OneToMany(mappedBy = "product")
    private List<IngredientEntity> ingredients;

}
