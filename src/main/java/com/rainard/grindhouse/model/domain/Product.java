package com.rainard.grindhouse.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Product {
    private Long id;
    @Column(name = "prod_name")
    private String prodName;
    private String prodPrice;
    private String prodDesc;
    private Boolean hasMilk;
    private Boolean hasCream;
    private Boolean hasSugar;
    private Boolean hadCondiments;
}

