package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.domain.model.common.AbstractBaseDomain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class Coffee extends AbstractBaseDomain {

    private String coffeeName;
    private String coffeePrice;
    private String coffeeDescription;

    @Builder.Default
    private Boolean hasMilk = false;

    @Builder.Default
    private Boolean hasCream = false;

    @Builder.Default
    private Boolean hasSugar = false;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Item> items;

}
