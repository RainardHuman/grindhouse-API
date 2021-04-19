package com.rainard.grindhouse.model.table;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "audit_log")
public class Audit_log {
    @GeneratedValue
    @Id
    private int Id;
    private int emp_id;
    private String action_type;
    private String notes;
}
