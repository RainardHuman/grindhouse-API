package com.rainard.grindhouse.domain.model;

import com.rainard.grindhouse.domain.model.common.AbstractBaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuditLog extends AbstractBaseDomain {

    private String actionType;
    private String notes;
    private Timestamp timestamp;

    private Employee employee;
}
