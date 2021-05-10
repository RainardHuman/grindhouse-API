package com.rainard.grindhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Customer {
    private String customerName;
    private String customerContact;
    private Integer orderCount;
    private Boolean isValid;
}
