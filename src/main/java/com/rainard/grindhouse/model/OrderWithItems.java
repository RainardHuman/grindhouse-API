package com.rainard.grindhouse.model;

import com.rainard.grindhouse.model.table.Item;
import lombok.Data;
import org.hibernate.criterion.Order;

import java.util.List;

@Data
public class OrderWithItems {
    private Order order;
    private List<Item> order_items;
}
