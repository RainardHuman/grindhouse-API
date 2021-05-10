package com.rainard.grindhouse.model;

import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import com.rainard.grindhouse.persistence.entity.OrdersEntity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Item {
    private Integer quantity;
    private Boolean milk;
    private Boolean sugar;
    private Boolean cream;
    private Integer orderVersion;
    private CoffeeEntity coffee;
}
