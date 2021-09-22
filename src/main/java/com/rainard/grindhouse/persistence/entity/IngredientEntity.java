package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@Getter
@Setter
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ingrName;

    @Column(nullable = false)
    private String ingrDesc;

    @Column(nullable = false)
    private String ingrAllergens;

    @ManyToOne
    @JoinColumn(name = "fk_prod_id", referencedColumnName = "id")
    private ProductEntity product;
}
