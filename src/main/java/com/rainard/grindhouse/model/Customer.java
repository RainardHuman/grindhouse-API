package com.rainard.grindhouse.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @GeneratedValue
    @Id
    private int id;
    private String cust_name;
    private String cust_contact;
    private int order_count;
    private boolean isValid;
}
