package com.rainard.grindhouse.persistence.entity;

import com.rainard.grindhouse.persistence.entity.common.AbstractBaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity extends AbstractBaseEntity {

    // ============ PROPERTIES ================
    @Column(name = "cust_name", nullable = false, updatable = false)
    private String custName;

    @Column(name = "cust_contact", nullable = false, updatable = false)
    private String custContact;

    @Column(name = "order_count", nullable = false, updatable = false)
    private int orderCount;

    @Column(name = "is_valid", nullable = false, updatable = false)
    private boolean isValid;
    // ========================================

    // ============ RELATIONSHIPS =============
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    @ToString.Exclude
    private List<OrdersEntity> ordersEntity;
    // ========================================

}
