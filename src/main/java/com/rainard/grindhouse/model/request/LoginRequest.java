package com.rainard.grindhouse.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class LoginRequest {
    @NotBlank(message = "employeeNumber can not be null or empty")
    private String employeeNumber;
    @NotBlank(message = "employeePassword can not be null or empty")
    private String employeePassword;
}
