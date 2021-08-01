package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@SuperBuilder
@Table(name = "order")
@Entity
@Getter
@Setter
@ToString(exclude = {"customer", "employee", "items"})
public class OrderEntity extends AbstractBaseEntity {

    @Column(name = "state")
    private String state;

    @Column(name= "total")
    private BigDecimal total;

    @CreatedDate
    @Column(name = "created")
    private Timestamp created;

    @LastModifiedDate
    @Column(name = "updated")
    private Timestamp updated;

    @ManyToOne
    @JoinColumn(name = "fk_cust_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "fk_emp_id")
    private EmployeeEntity employee;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ItemEntity> items;
}
