package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@SuperBuilder
@Table(name = "employee")
@Entity
@Getter
@Setter
@ToString(exclude = {"empNumber","empPassword","orders", "auditLogs"})
public class EmployeeEntity extends AbstractBaseEntity {

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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AuditLogEntity> auditLogs;

}
