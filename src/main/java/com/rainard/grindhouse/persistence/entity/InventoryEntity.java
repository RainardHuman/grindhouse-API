package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@SuperBuilder
@Table(name = "inventory")
@Entity
@Getter
@Setter
@ToString(exclude = {"ingredients"})
public class InventoryEntity extends AbstractBaseEntity {

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

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<IngredientEntity> ingredients;

}
