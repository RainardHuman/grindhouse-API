package com.rainard.grindhouse.model.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit_log")
public class AuditLog {
    @GeneratedValue
    @Id
    private int Id;
    @Column(name = "fk_emp_id")
    private int empId;
    @Column(name = "action_type")
    private String actionType;
    private String notes;
    private Timestamp timestamp;
}
