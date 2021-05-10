package com.rainard.grindhouse.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class UpdateOrderStateRequest {
    private String sessionToken;
    private Long orderId;
    private String state;
}
