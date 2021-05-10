package com.rainard.grindhouse.model;


import com.rainard.grindhouse.persistence.entity.OrdersEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
public class OrderWithItems {
    private OrdersEntity order;
    // Items are within order object.
}
