package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import lombok.AllArgsConstructor;
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
public class Item extends AbstractBaseEntity {

    private Integer quantity;
    private Boolean milk;
    private Boolean sugar;
    private Boolean cream;
    private Integer orderVersion;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Coffee coffee;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Orders order;

}
