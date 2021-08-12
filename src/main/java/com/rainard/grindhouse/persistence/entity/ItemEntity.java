package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "sugar", nullable = false)
    private Integer sugarQty;

    @Column(name = "cream", nullable = false)
    private Integer creamQty;

    @Column(name = "milk", nullable = false)
    private Boolean milk;

    @Column(name = "condiments", nullable = false)
    private Boolean condiments;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_order_id")
    private OrderEntity order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_prod_id")
    private ProductEntity product;

}
