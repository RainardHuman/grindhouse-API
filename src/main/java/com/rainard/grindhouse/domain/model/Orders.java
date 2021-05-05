package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;

import java.util.List;

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
public class Orders extends AbstractBaseEntity {

    private String state;
    private Integer version;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Customer customer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Item> items;
}
