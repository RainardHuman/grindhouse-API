package com.rainard.grindhouse.model.response;

import lombok.Data;

@Data
public class FailResponse {
    private String error;
    private String message;
}
