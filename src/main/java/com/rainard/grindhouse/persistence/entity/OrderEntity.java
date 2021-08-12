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

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @CreatedDate
    @Column(name = "created")
    private Timestamp created;

    @LastModifiedDate
    @Column(name = "updated")
    private Timestamp updated;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_cust_id")
    private CustomerEntity customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_emp_id")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "order")
    private List<ItemEntity> items;
}
