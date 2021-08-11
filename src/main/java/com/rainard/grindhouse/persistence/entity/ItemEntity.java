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

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "prodId")
    private ProductEntity product;

}
