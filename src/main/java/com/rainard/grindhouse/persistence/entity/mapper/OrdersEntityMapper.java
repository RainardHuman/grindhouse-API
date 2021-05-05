package com.rainard.grindhouse.persistence.entity.mapper;

import com.rainard.grindhouse.domain.model.Orders;
import com.rainard.grindhouse.persistence.entity.OrdersEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {ItemEntityMapper.class, CustomerEntityMapper.class, EmployeeEntityMapper.class}
)
public interface OrdersEntityMapper {

    OrdersEntity map(Orders orders);

}
