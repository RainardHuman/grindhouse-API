package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit_log")
public class AuditLogEntity extends AbstractBaseEntity {

    // ============ PROPERTIES ================
    @Column(name = "action_type", nullable = false, updatable = false)
    private String actionType;

    @Column(name = "notes", nullable = false, updatable = false)
    private String notes;

    @Column(name = "timestamp", nullable = false , updatable = false)
    private Timestamp timestamp;
    // ========================================

    // ============ RELATIONSHIPS =============
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, updatable = false)
    @ToString.Exclude
    private EmployeeEntity employeeEntity;
    // ========================================

}
