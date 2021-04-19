package com.rainard.grindhouse.model.table;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @GeneratedValue
    @Id
    private int id;
    private String emp_number;
    private String emp_password;
    private String emp_name;
}
