package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.model.domain.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class ViewOrderResponse {
    private Order order;
}