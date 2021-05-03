package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity extends AbstractBaseEntity {

    // ============ PROPERTIES ================
    @Column(name = "quantity", nullable = false, updatable = false)
    private Integer quantity;

    @Column(name = "milk", nullable = false, updatable = false)
    private Boolean milk;

    @Column(name = "sugar", nullable = false, updatable = false)
    private Boolean sugar;

    @Column(name = "cream", nullable = false, updatable = false)
    private Boolean cream;

    @Column(name = "order_version", nullable = false, updatable = false)
    private Integer orderVersion;
    // ========================================

    // ============ RELATIONSHIPS =============
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee_id")
    @ToString.Exclude
    private CoffeeEntity coffeeEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private OrdersEntity order;
    // ========================================

}
