package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.domain.model.common.AbstractBaseDomain;

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
public class AuditLog extends AbstractBaseDomain {

    private String actionType;
    private String notes;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Employee employee;

}
