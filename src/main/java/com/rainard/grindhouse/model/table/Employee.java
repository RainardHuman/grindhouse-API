package com.rainard.grindhouse.model.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @GeneratedValue
    @Id
    private int id;
    @Column(name = "emp_number")
    private String empNumber;
    @Column(name = "emp_password")
    private String empPassword;
    @Column(name = "emp_name")
    private String empName;
    private Boolean isLoggedIn;
}
