package com.rainard.grindhouse.model.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Order {
    private Long id;
    private Timestamp created;
    private Timestamp lastUpdated;
    private String state;
    private Integer version;
    private Customer customer;
    private Employee employee;
    private List<Item> items;
}
