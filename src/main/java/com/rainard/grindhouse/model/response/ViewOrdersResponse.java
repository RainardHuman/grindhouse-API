package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.model.domain.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class ViewOrdersResponse {
    private List<Order> orders;
}
