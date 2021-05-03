package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Item extends AbstractBaseEntity {

    private Integer quantity;
    private Boolean milk;
    private Boolean sugar;
    private Boolean cream;
    private Integer orderVersion;

    private CoffeeEntity coffeeEntity;
    private Orders order;

}
