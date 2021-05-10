package com.rainard.grindhouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class CapturedItem {
    private int quantity;
    private Long coffeeId;
    private boolean milk;
    private boolean sugar;
    private boolean cream;
}
