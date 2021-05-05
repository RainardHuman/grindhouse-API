package com.rainard.grindhouse.model;

import com.rainard.grindhouse.domain.model.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@SuperBuilder
public class OrderWithItems {
    private Orders order;
    // Items are within order object.
}
