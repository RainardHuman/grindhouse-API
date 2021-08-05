package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingrId;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "invId")
    private InventoryEntity inventory;

}
