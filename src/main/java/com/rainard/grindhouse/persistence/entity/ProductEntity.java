package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    private long id;

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_price")
    private BigDecimal prodPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "has_milk")
    private Boolean hasMilk;

    @Column(name = "has_cream")
    private Boolean hasCream;

    @Column(name = "has_sugar")
    private Boolean hasSugar;

    @Column(name = "has_condiments")
    private Boolean hasCondiments;

    @OneToMany(mappedBy = "product")
    private List<ItemEntity> items;

    @OneToMany(mappedBy = "product")
    private List<IngredientEntity> ingredients;

}
