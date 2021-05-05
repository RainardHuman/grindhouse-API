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
public class Customer extends AbstractBaseEntity {

    private String customerName;
    private String customerContact;
    private Integer orderCount;
    private Boolean isValid;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Orders> orders;

}
