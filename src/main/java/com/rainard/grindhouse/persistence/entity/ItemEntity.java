package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "item")
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private long id;

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
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private ProductEntity product;

}
