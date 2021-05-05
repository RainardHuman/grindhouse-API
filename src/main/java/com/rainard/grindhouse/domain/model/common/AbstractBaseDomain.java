package com.rainard.grindhouse.domain.model.common;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseDomain implements Serializable {

    private Long id;

    @EqualsAndHashCode.Exclude
    private Timestamp created;

    @EqualsAndHashCode.Exclude
    private Timestamp updated;
}
