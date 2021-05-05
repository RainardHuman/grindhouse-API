package com.rainard.grindhouse.persistence.entity.mapper;

import com.rainard.grindhouse.domain.model.Item;
import com.rainard.grindhouse.persistence.entity.ItemEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {OrdersEntityMapper.class, CoffeeEntityMapper.class}
)
public interface ItemEntityMapper {

    ItemEntity map(Item item);

}
