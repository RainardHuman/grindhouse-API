package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Table(name = "item")
@Entity
public class ItemEntity extends AbstractBaseEntity {

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sugar")
    private Integer sugarQty;

    @Column(name = "cream")
    private Integer creamQty;

    @Column(name = "milk")
    private Boolean milk;

    @Column(name = "condiments")
    private Boolean condiments;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id")
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_prod_id")
    private ProductEntity product;

}
