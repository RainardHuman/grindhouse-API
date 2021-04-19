package com.rainard.grindhouse.model.request;

import lombok.Data;

@Data
public class OrderUpdateRequest {
    private int order_id;
    private String state;
}
