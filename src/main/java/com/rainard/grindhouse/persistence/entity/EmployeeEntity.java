package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstractBaseEntity {

    // ============ PROPERTIES ================
    @Column(name = "employee_number", nullable = false, updatable = false)
    private String employeeNumber;

    @Column(name = "employee_password", nullable = false, updatable = false)
    private String employeePassword;

    @Column(name = "employee_name", nullable = false, updatable = false)
    private String employeeName;

    @Column(name = "is_logged_in", nullable = false, updatable = false)
    private Boolean isLoggedIn;
    // ========================================

    // ============ RELATIONSHIPS =============
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private List<AuditLogEntity> auditLogRepositories;
    // ========================================

}
