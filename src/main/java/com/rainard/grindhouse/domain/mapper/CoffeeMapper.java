package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.Coffee;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {ItemMapper.class}
)
public interface CoffeeMapper {

    Coffee map(CoffeeEntity coffeeEntity);

    List<Coffee> map(List<CoffeeEntity> coffeeEntities);

}
