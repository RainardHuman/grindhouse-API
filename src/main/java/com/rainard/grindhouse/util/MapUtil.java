package com.rainard.grindhouse.util;

import com.rainard.grindhouse.model.Coffee;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;

import java.util.ArrayList;
import java.util.List;

public class MapUtil {
    public List<Coffee> mapCoffees(List<CoffeeEntity> coffeeEntities) {
        List<Coffee> coffees = new ArrayList<>();
        coffeeEntities.forEach(coffeeEntity -> {
            coffees.add(Coffee.builder()
                .coffeeName(coffeeEntity.getCoffeeName())
                .coffeeDescription(coffeeEntity.getCoffeeDescription())
                .coffeePrice(coffeeEntity.getCoffeePrice())
                .hasMilk(coffeeEntity.getHasMilk())
                .hasCream(coffeeEntity.getHasCream())
                .hasSugar(coffeeEntity.getHasSugar())
                .build());
        });
        return coffees;
    }
}
