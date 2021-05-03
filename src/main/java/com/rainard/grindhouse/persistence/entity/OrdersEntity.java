package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "ordersEntity")
public class OrdersEntity extends AbstractBaseEntity {

    // ============ PROPERTIES ================
    @Column(name = "state", nullable = false, updatable = false)
    private String state;

    @Column(name = "version", nullable = false, updatable = false)
    private Integer version;
    // ========================================

    // ============ RELATIONSHIPS =============
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    @ToString.Exclude
    private CustomerEntity customerEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @ToString.Exclude
    private List<ItemEntity> itemEntities;
    // ========================================

}
