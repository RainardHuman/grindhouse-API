package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class Employee extends AbstractBaseEntity {

    private String employeeNumber;
    private String employeePassword;
    private String employeeName;
    private Boolean isLoggedIn;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Orders> orders;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<AuditLog> auditLogs;

}
