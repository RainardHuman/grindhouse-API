package com.rainard.grindhouse.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@Getter
@Setter
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String shopName;

    @CreatedDate
    @Column(nullable = false)
    private Date created;

    @Column(nullable = false)
    private Boolean inOperation;

    @ManyToOne(optional = false)
    private ShopOwnerEntity shopOwner;

    @OneToMany(mappedBy = "shop")
    private List<ShopEmployeeEntity> employees;

}
