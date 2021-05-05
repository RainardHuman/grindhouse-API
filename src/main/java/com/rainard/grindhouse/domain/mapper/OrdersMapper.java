package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.Orders;
import com.rainard.grindhouse.persistence.entity.OrdersEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {ItemMapper.class, CustomerMapper.class, EmployeeMapper.class}
)
public interface OrdersMapper {

    Orders map(OrdersEntity ordersEntity);

}
