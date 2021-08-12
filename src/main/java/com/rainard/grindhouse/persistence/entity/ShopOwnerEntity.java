package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShopOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopOwnerId;

    @OneToOne(optional = false)
    @JoinColumn(name = "fk_shop_id")
    private ShopEntity shop;

    @OneToOne(optional = false)
    @JoinColumn(name = "fk_emp_id")
    private EmployeeEntity employee;
}
