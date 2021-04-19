package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.model.table.Coffee;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private int employee_id;
    private String employee_name;
    private List<Coffee> coffees;
}
