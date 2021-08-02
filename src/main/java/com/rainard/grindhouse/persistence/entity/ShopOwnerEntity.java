package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "shop_owner")
@Entity
public class ShopOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_owner_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;
}
