package com.rainard.grindhouse.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopId;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @CreatedDate
    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "in_operation", nullable = false)
    private String inOperation;

    @OneToOne(mappedBy = "shop")
    private ShopOwnerEntity shopOwner;

    @OneToMany(mappedBy = "shop")
    private List<ShopEmployeeEntity> employees;

}
