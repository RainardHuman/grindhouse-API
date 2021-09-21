package com.rainard.grindhouse.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@NoArgsConstructor
@Getter
@Setter
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer sugarQty;

    @Column(nullable = false)
    private Integer creamQty;

    @Column(nullable = false)
    private Boolean milk;

    @Column(nullable = false)
    private Boolean condiments;

    @ManyToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "fk_prod_id", referencedColumnName = "id")
    private ProductEntity product;

}
