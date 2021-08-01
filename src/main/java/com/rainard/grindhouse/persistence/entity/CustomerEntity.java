package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "customer")
public class CustomerEntity extends AbstractBaseEntity {

    @Column(name = "cust_name")
    private String customerName;

    @Column(name = "cell")
    private String customerContact;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "isValid")
    private Boolean isValid;

    @CreatedDate
    @Column(name = "created")
    private Timestamp created;

    @LastModifiedDate
    @Column(name = "updated")
    private Timestamp updated;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

}
