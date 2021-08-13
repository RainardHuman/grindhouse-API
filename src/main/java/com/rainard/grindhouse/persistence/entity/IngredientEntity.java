package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingrId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_prod_id")
    private ProductEntity product;

    @Column(name = "ingr_name", nullable = false, unique = true)
    private String ingrName;

    @Column(name = "ingr_desc", nullable = false)
    private String ingrDesc;

    @Column(name = "ingr_allergens", nullable = false)
    private String ingrAllergens;

}
