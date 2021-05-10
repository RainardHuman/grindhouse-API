package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.persistence.entity.CustomerEntity;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.entity.ItemEntity;

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
public class ViewOrderResponse {
    private String state;
    private Integer version;
    private CustomerEntity customer;
    private EmployeeEntity employee;
    private List<ItemEntity> items;
    private Timestamp created;
    private Timestamp updated;
}
