package com.rainard.grindhouse.model.response;

import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import lombok.Data;

import java.util.List;

@Data

public class LoginResponse {
    private int employeeId;
    private String employeeName;
    private List<CoffeeEntity> coffeeEntities;
}
