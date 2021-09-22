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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String prodName;

    @Column(nullable = false)
    private BigDecimal prodPrice;

    @Column(nullable = false)
    private String prodDesc;

    @Column(nullable = false)
    private Boolean hasMilk;

    @Column(nullable = false)
    private Boolean hasCream;

    @Column(nullable = false)
    private Boolean hasSugar;

    @Column(nullable = false)
    private Boolean hasCondiments;

    @OneToMany(mappedBy = "product")
    private List<ItemEntity> items;

    @OneToMany(mappedBy = "product")
    private List<IngredientEntity> ingredients;

}
