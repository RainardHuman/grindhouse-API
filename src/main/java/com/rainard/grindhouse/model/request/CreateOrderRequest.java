package com.rainard.grindhouse.model.request;

import com.rainard.grindhouse.model.CapturedItem;
import com.rainard.grindhouse.model.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class CreateOrderRequest {
    private String sessionToken;
    private Customer customer;
    private List<CapturedItem> items;
}
