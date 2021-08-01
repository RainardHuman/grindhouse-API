package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@SuperBuilder
@Table(name = "audit_log")
@Entity
public class AuditLogEntity extends AbstractBaseEntity {

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "note")
    private String note;

    @CreatedDate
    @Column(name = "created")
    private Timestamp created;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

}
