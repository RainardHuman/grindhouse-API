package com.rainard.grindhouse.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "audit_log")
@NoArgsConstructor
@Getter
@Setter
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String actionType;

    @Column(nullable = false)
    private String note;

    @CreatedDate
    @Column(nullable = false)
    private Timestamp created;

    @OneToOne
    @JoinColumn(name = "fk_order_id", referencedColumnName = "id")
    private OrderEntity order;

}
