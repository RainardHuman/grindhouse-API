package com.rainard.grindhouse.model.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee {
    @GeneratedValue
    @Id
    private int id;
    @Column(name = "coff_name")
    private String coffName;
    @Column(name = "coff_price")
    private String coffPrice;
    @Column(name = "coff_desc")
    private String coffDesc;
    @Column(name = "has_milk")
    private boolean hasMilk;
    @Column(name = "has_cream")
    private boolean hasCream;
    @Column(name = "has_sugar")
    private boolean hasSugar;
}
