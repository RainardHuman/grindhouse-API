package com.rainard.grindhouse.persistence.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Timestamp;

@Table(name = "audit_log")
@Entity
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "audit_id")
    private long id;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "note")
    private String note;

    @CreatedDate
    @Column(name = "created")
    private Timestamp created;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private EmployeeEntity employee;

}
