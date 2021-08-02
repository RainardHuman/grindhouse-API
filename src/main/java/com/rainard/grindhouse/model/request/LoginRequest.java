package com.rainard.grindhouse.model.request;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
public class LoginRequest {
    @NotBlank(message = "employeeNumber can not be null or empty")
    private String employeeNumber;
    @NotBlank(message = "employeePassword can not be null or empty")
    private String employeePassword;
}
