package com.rainard.grindhouse.dto.request;

import javax.validation.constraints.NotBlank;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorisationLoginDTO implements Serializable {
    @NotBlank(message = "employeeNumber can not be null or blank")
    private String employeeNumber;
    @NotBlank(message = "employeePassword can not be null or blank")
    private String employeePassword;
}
