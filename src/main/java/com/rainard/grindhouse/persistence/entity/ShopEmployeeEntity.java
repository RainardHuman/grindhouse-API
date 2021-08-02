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
@Table(name = "shop_employee")
public class ShopEmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_emp_id")
    private long id;

    @Column(name = "role")
    private RoleEnum role;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;
}
