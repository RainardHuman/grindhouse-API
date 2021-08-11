package com.rainard.grindhouse.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private String sessionToken;
    private String employeeName;
}
