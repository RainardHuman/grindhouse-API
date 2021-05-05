package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.Item;
import com.rainard.grindhouse.persistence.entity.ItemEntity;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {OrdersMapper.class, CoffeeMapper.class}
)
public interface ItemMapper {

    Item map(ItemEntity itemEntity);

    List<Item> map(List<ItemEntity> itemEntity);

}
