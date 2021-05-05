package com.rainard.grindhouse.persistence.entity.mapper;

import com.rainard.grindhouse.domain.model.Employee;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {OrdersEntityMapper.class, AuditLogEntityMapper.class}
)
public interface EmployeeEntityMapper {

    EmployeeEntity map(Employee employee);

}
