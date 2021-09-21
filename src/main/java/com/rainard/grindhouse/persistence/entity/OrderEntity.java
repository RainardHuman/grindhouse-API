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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private BigDecimal total;

    @CreatedDate
    @Column(nullable = false)
    private Timestamp created;

    @LastModifiedDate
    @Column(nullable = false)
    private Timestamp updated;

    @ManyToOne
    @JoinColumn(name = "fk_cust_id", referencedColumnName = "id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<ItemEntity> items;

    @OneToOne(mappedBy = "order")
    private AuditLogEntity auditLogEntity;
}
