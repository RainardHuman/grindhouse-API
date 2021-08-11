package com.rainard.grindhouse.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invId;

    @Column(name = "description")
    private String description;

    @Column(name = "allergens")
    private String allergens;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @OneToMany
    private List<IngredientEntity> ingredients;

}
