package com.rainard.grindhouse.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private long id;

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
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "employee")
    private List<AuditLogEntity> auditLogs;

    @OneToOne(mappedBy = "employee")
    private ShopOwnerEntity shopOwner;
}
