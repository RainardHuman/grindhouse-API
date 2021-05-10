package com.rainard.grindhouse.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Coffee {
    private String name;
    private String price;
    private String description;
    private Boolean hasMilk;
    private Boolean hasCream;
    private Boolean hasSugar;
}

