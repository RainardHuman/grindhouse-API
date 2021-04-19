package com.rainard.grindhouse.model.table;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Orders {
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
