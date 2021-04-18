package com.rainard.grindhouse.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item")
public class Item {
    @GeneratedValue
    @Id
    private int id;
    private int fk_coffee_id;
    private int fk_order_id;
    private int quantity;
    private boolean milk;
    private boolean sugar;
    private boolean cream;
}
