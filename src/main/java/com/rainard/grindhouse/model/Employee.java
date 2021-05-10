package com.rainard.grindhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Employee {
    private Long id;
    private String employeeName;
    private Boolean isLoggedIn;
}
