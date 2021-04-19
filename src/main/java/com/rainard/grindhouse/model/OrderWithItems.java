package com.rainard.grindhouse.model;

import com.rainard.grindhouse.model.table.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderWithItems {
    private Order order;
    private List<Item> order_items;
}
