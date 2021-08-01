package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuperBuilder
@Table(name = "ingredient")
@Entity
@Getter
public class IngredientEntity extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "fk_prod_id")
    private ProductEntity products;

    @ManyToOne
    @JoinColumn(name = "fk_inv_id")
    private InventoryEntity inventory;

}
