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

@Entity
public class ShopEmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopEmpId;

    @Column(name = "role", nullable = false)
    private RoleEnum role;

    @OneToOne(optional = false)
    @JoinColumn(name = "fk_emp_id")
    private EmployeeEntity employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_shop_id")
    private ShopEntity shop;
}
