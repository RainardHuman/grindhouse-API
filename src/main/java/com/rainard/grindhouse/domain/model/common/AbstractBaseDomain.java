package com.rainard.grindhouse.domain.model.common;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public abstract class AbstractBaseDomain implements Serializable {
    private Timestamp created;
    private Timestamp updated;
}
