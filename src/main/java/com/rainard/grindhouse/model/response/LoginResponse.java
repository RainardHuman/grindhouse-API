package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.model.table.Coffee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoginResponse {
    private int employeeId;
    private String employeeName;
    private List<Coffee> coffees;
}
