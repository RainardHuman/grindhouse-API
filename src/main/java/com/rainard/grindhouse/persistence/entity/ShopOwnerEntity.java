package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shop_owner")
@NoArgsConstructor
@Getter
@Setter
public class ShopOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    @JoinColumn(name = "fk_shop_id", referencedColumnName = "id")
    private List<ShopEntity> shop;

    @OneToOne
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
    private EmployeeEntity employee;
}
