package com.rainard.grindhouse.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "state")
    private String state;

    @Column(name = "total")
    private BigDecimal total;

    @CreatedDate
    @Column(name = "created")
    private Timestamp created;

    @LastModifiedDate
    @Column(name = "updated")
    private Timestamp updated;

    @ManyToOne
    @JoinColumn(name = "custId")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "empId")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "order")
    private List<ItemEntity> items;
}
