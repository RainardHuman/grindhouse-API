package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.Coffee;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface CoffeeMapper {

    Coffee map(CoffeeEntity coffeeEntity);

}
