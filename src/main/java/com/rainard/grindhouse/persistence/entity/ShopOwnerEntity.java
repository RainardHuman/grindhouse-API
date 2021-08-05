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

    @OneToOne
    @JoinColumn(name = "shopId")
    private ShopEntity shop;

    @OneToOne
    @JoinColumn(name = "empId")
    private EmployeeEntity employee;
}
