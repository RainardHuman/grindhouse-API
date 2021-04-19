package com.rainard.grindhouse.model.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @GeneratedValue
    @Id
    private int id;
    @Column(name = "fk_emp_id")
    private int fkEmpId;
    @Column(name = "fk_cust_id")
    private int fkCustId;
    private String state;
    @Column(name = "time_start")
    private Timestamp timeStart;
    @Column(name = "time_stop")
    private Timestamp timeStop;
    private double total;
}
