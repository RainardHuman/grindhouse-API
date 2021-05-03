package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.domain.model.common.AbstractBaseDomain;
import com.rainard.grindhouse.persistence.entity.ItemEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Coffee extends AbstractBaseDomain {

    private String coffeeName;
    private Double coffeePrice;
    private String coffeeDescription;
    private Boolean hasMilk;
    private Boolean hasCream;
    private Boolean hasSugar;

    private List<ItemEntity> itemEntities;

    public Double calculatePrice() {
        return this.coffeePrice;
    }
}
