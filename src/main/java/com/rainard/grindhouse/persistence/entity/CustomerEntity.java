package com.rainard.grindhouse.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cust_name", nullable = false)
    private String custName;

    @Column(name = "cell")
    private String custContact;

    @Column(name = "order_count", nullable = false)
    private Integer orderCount;

    @CreatedDate
    @Column(name = "created", nullable = false)
    private Timestamp created;

    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    private Timestamp updated;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
