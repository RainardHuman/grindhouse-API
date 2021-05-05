package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.domain.model.Coffee;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class LoginResponse {
    private Long employeeId;
    private String employeeName;
    private List<Coffee> coffees;
}
