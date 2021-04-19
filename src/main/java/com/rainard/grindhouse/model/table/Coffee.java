package com.rainard.grindhouse.model.table;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "coffee")
public class Coffee {
    @GeneratedValue
    @Id
    private int id;
    private String coff_name;
    private String coff_price;
    private String coff_desc;
    private boolean has_milk;
    private boolean has_cream;
    private boolean has_sugar;
}
