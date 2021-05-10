package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@Table(name = "coffee")
public class CoffeeEntity extends AbstractBaseEntity {

    @Column(name = "coffee_name")
    private String coffeeName;

    @Column(name = "coffee_price")
    private String coffeePrice;

    @Column(name = "coffee_description")
    private String coffeeDescription;

    @Builder.Default
    @Column(name = "has_milk")
    private Boolean hasMilk = false;

    @Builder.Default
    @Column(name = "has_cream")
    private Boolean hasCream = false;

    @Builder.Default
    @Column(name = "has_sugar")
    private Boolean hasSugar = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coffee", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ItemEntity> items;

}
