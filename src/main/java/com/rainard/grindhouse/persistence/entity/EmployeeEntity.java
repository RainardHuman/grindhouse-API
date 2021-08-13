package com.rainard.grindhouse.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long empId;

    @Column(name = "emp_number", nullable = false, unique = true)
    private String empNumber;

    @Column(name = "emp_password", nullable = false)
    private String empPassword;

    @Column(name = "emp_name", nullable = false)
    private String empName;

    @Column(name = "logged_in", nullable = false)
    private Boolean isLoggedIn;

    @CreatedDate
    @Column(name = "created", nullable = false)
    private Date created;

    @LastModifiedDate
    @Column(name = "updated", nullable = false)
    private Date updated;

    @OneToOne(mappedBy = "employee")
    private ShopEmployeeEntity shopEmployee;

    @OneToMany(mappedBy = "employee")
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "employee")
    private List<AuditLogEntity> auditLogEntities;

    @OneToOne(mappedBy = "employee")
    private ShopOwnerEntity shopOwner;

}
