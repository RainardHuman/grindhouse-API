package com.rainard.grindhouse.model.response;


import java.util.List;

import com.rainard.grindhouse.model.domain.Coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class LoginResponse {
    private String sessionToken;
    private String employeeName;
    private List<Coffee> coffees;
}
