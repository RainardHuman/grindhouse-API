package com.rainard.grindhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Coffee {
    private String coffeeName;
    private String coffeePrice;
    private String coffeeDescription;
    private Boolean hasMilk = false;
    private Boolean hasCream = false;
    private Boolean hasSugar = false;
}

