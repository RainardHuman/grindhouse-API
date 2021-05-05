package com.rainard.grindhouse.persistence.entity.mapper;

import com.rainard.grindhouse.domain.model.Customer;
import com.rainard.grindhouse.persistence.entity.CustomerEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {OrdersEntityMapper.class}
)
public interface CustomerEntityMapper {

    CustomerEntity map(Customer customer);

}
