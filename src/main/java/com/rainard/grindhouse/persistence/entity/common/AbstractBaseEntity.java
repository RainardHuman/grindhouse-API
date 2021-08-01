package com.rainard.grindhouse.persistence.entity.common;

import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.io.Serializable;

@SuperBuilder
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

}
