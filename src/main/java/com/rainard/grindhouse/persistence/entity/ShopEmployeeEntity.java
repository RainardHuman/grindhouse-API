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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shop_employee")
@NoArgsConstructor
@Getter
@Setter
public class ShopEmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private RoleEnum role;

    @OneToOne
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "fk_shop_id", referencedColumnName = "id")
    private ShopEntity shop;
}
