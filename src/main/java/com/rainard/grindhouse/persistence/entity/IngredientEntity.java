package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "ingredient")
@Entity
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingr_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "inv_id")
    private InventoryEntity inventory;

}
