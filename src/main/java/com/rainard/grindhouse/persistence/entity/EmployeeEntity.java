package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@Table(name = "employee")
public class EmployeeEntity extends AbstractBaseEntity {

    @Column(name = "employee_number", nullable = false, updatable = false)
    private String employeeNumber;

    @Column(name = "employee_password", nullable = false, updatable = false)
    private String employeePassword;

    @Column(name = "employee_name", nullable = false, updatable = false)
    private String employeeName;

    @Column(name = "is_logged_in", nullable = false, updatable = false)
    private Boolean isLoggedIn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<OrdersEntity> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<AuditLogEntity> auditLogs;

}
