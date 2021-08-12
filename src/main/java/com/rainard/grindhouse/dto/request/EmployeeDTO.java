package com.rainard.grindhouse.dto.request;


import javax.validation.constraints.Min;
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
public class EmployeeDTO implements Serializable {
    @NotBlank(message = "employeeName can not be null or blank")
    private String employeeName;
    @NotBlank(message = "employeeName can not be null or blank")
    private String employeeNumber;
    @Size(min = 8, message = "employeeName must be more than or equal to 8 characters")
    @NotBlank(message = "employeeName can not be null or blank")
    private String employeePassword;
}
