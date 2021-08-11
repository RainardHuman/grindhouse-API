package com.rainard.grindhouse.model.response;

import lombok.Builder;

@Builder
public class LoginResponse {
    private String sessionToken;
    private String employeeName;
}
