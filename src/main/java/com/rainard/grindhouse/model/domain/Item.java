package com.rainard.grindhouse.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class Item {
    private Integer quantity;
    private Boolean milk;
    private Boolean sugar;
    private Boolean cream;
    private Integer orderVersion;
    private Product coffee;
}
