package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.enums.RoleEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class ShopEmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopEmpId;

    @Column(name = "role")
    private RoleEnum role;

    @OneToOne
    @JoinColumn(name = "empId")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "shopId")
    private ShopEntity shop;
}
