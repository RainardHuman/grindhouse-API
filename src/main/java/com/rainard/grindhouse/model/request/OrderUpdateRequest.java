package com.rainard.grindhouse.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderUpdateRequest {
    private int order_id;
    private String state;
}
