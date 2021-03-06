package com.rainard.grindhouse.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDTO implements Serializable {
    @NotBlank(message = "employeeName can not be null or blank")
    private String employeeName;
    @NotBlank(message = "employeeNumber can not be null or blank")
    private String employeeNumber;
    @Size(min = 8, message = "employeePassword must be more than or equal to 8 characters")
    @NotBlank(message = "employeePassword can not be null or blank")
    private String employeePassword;
}
