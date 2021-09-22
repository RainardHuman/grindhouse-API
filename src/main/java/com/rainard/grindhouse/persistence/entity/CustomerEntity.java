package com.rainard.grindhouse.persistence.entity;

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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String custName;

    @Column
    private String custContact;

    @Column(nullable = false)
    private Integer orderCount;

    @CreatedDate
    @Column(nullable = false)
    private Timestamp created;

    @LastModifiedDate
    @Column(nullable = false)
    private Timestamp updated;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
