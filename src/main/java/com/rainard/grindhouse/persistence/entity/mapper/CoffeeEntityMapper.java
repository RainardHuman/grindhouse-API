package com.rainard.grindhouse.persistence.entity.mapper;

import com.rainard.grindhouse.domain.model.Coffee;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {ItemEntityMapper.class}
)
public interface CoffeeEntityMapper {

    CoffeeEntity map(Coffee coffee);

    List<CoffeeEntity> map(List<Coffee> coffees);

}
