package com.rainard.grindhouse.persistence.entity;

import lombok.Setter;

import lombok.ToString;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@ToString
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;

    @Column(name = "emp_number")
    private String empNumber;

    @Column(name = "emp_password")
    private String empPassword;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "logged_in")
    private Boolean isLoggedIn;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    @OneToOne(mappedBy = "employee")
    private ShopEmployeeEntity shopEmployee;

    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    private List<AuditLogEntity> auditLogEntities;

    @OneToOne(mappedBy = "employee")
    private ShopOwnerEntity shopOwner;

    public List<AuditLogEntity> getAuditLogEntities() {
        return auditLogEntities;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }
}
