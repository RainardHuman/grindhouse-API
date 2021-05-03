package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends AbstractBaseEntity {

    private String employeeNumber;
    private String employeePassword;
    private String employeeName;
    private boolean isLoggedIn;

    private List<AuditLog> auditLogRepositories;

}
