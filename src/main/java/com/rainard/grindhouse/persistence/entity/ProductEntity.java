package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Table(name = "product")
public class ProductEntity extends AbstractBaseEntity {

    @Column(name = "prod_name")
    private String prodName;

    @Column(name = "prod_price")
    private BigDecimal prodPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "has_milk")
    private Boolean hasMilk = false;

    @Column(name = "has_cream")
    private Boolean hasCream = false;

    @Column(name = "has_sugar")
    private Boolean hasSugar = false;

    @Column(name = "has_condiments")
    private Boolean hasCondiments = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemEntity> items;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<IngredientEntity> ingredients;

}
