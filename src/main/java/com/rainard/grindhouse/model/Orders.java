package com.rainard.grindhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @GeneratedValue
    @Id
    private int id;
    private int fk_emp_id;
    private int fk_cust_id;
    private String state;
    private Timestamp time_start;
    private Timestamp time_stop;
    private double total;
}
