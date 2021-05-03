package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data

public class Customer extends AbstractBaseEntity {

    private String custName;
    private String custContact;
    private int orderCount;
    private boolean isValid;

    private List<Orders> ordersEntity;

}
