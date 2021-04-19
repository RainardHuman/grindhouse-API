package com.rainard.grindhouse.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FailResponse {
    private String error;
    private String message;
}
