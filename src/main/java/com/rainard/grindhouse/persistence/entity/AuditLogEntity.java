package com.rainard.grindhouse.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auditId;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    @Column(name = "note", nullable = false)
    private String note;

    @CreatedDate
    @Column(name = "created", nullable = false)
    private Timestamp created;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_emp_id")
    private EmployeeEntity employee;

}
