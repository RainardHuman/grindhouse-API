package com.rainard.grindhouse.model.domain;

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
    private String name;
    private Boolean isLoggedIn;
}
