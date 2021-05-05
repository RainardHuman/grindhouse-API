package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.Customer;
import com.rainard.grindhouse.persistence.entity.CustomerEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {OrdersMapper.class}
)
public interface CustomerMapper {

    Customer map(CustomerEntity customerEntity);

}
