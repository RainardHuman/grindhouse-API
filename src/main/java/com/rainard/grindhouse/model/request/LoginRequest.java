package com.rainard.grindhouse.model.request;

import lombok.Builder;
import lombok.Data;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Builder
@Validated
@Data
public class LoginRequest {
    @NotBlank(message = "employeeNumber can not be null or empty")
    private String employeeNumber;
    @NotBlank(message = "employeePassword can not be null or empty")
    private String employeePassword;
}
