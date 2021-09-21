package com.rainard.grindhouse.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String empNumber;

    @Column(nullable = false)
    private String empPassword;

    @Column(nullable = false)
    private String empName;

    @Column(nullable = false)
    private Boolean isLoggedIn;

    @CreatedDate
    @Column(nullable = false)
    private Date created;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updated;

    @OneToMany(mappedBy = "employee")
    private List<OrderEntity> orders;

    @OneToOne(mappedBy = "employee", orphanRemoval = true)
    private ShopEmployeeEntity shopEmployee;

    @OneToOne(mappedBy = "employee", orphanRemoval = true)
    private ShopOwnerEntity shopOwner;

}
