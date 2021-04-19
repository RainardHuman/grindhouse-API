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
@Table(name = "customer")
public class Customer {
    @GeneratedValue
    @Id
    private int id;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_contact")
    private String custContact;
    @Column(name = "order_count")
    private int orderCount;
    private boolean isValid;
}
