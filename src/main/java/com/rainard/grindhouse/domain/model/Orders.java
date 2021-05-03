package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Orders extends AbstractBaseEntity {

    private String state;
    private Integer version;

    private Customer customerEntity;
    private List<Item> itemEntities;

}
