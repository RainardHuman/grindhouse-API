package com.rainard.grindhouse.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {
    @NotBlank(message = "employeeNumber can not be null or blank")
    private String employeeNumber;
    @NotBlank(message = "employeePassword can not be null or blank")
    private String employeePassword;
}
