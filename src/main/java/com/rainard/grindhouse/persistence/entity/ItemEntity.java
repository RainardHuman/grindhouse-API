package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@Table(name = "item")
public class ItemEntity extends AbstractBaseEntity {

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "coffee_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CoffeeEntity coffee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private OrdersEntity order;

}
