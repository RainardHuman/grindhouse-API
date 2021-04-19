package com.rainard.grindhouse.model.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @GeneratedValue
    @Id
    private int id;
    @Column(name = "fk_coffee_id")
    private int fkCoffeeId;
    @Column(name = "fk_order_id")
    private int fkOrderId;
    private int quantity;
    private boolean milk;
    private boolean sugar;
    private boolean cream;
}
