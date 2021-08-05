package com.rainard.grindhouse.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@Entity
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopId;

    @Column(name = "shop_name")
    private String shopName;

    @OneToOne(mappedBy = "shop")
    private ShopOwnerEntity shopOwner;

    @OneToMany(mappedBy = "shop")
    private List<ShopEmployeeEntity> employees;

}
