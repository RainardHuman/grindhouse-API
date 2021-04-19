package com.rainard.grindhouse.model;

import com.rainard.grindhouse.model.table.Item;
import com.rainard.grindhouse.model.table.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderWithItems {
    private Orders order;
    private List<Item> orderItems;
}
