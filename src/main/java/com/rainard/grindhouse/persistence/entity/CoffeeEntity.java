package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coffee")
public class CoffeeEntity extends AbstractBaseEntity {

    // ============ PROPERTIES ================
    @Column(name = "coffee_name", updatable = false, nullable = false)
    private String coffeeName;

    @Column(name = "coffee_price", updatable = false, nullable = false)
    private String coffeePrice;

    @Column(name = "coffee_description", nullable = false, updatable = false)
    private String coffeeDescription;

    @Column(name = "has_milk", nullable = false, updatable = false)
    private Boolean hasMilk = false;

    @Column(name = "has_cream", nullable = false, updatable = false)
    private Boolean hasCream = false;

    @Column(name = "has_sugar", nullable = false, updatable = false)
    private Boolean hasSugar = false;
    // ========================================

    // ============ RELATIONSHIPS =============
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coffee")
    private List<ItemEntity> itemEntities;
    // ========================================

}
