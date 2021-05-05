package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.Employee;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {OrdersMapper.class, AuditLogMapper.class}
)
public interface EmployeeMapper {

    Employee map(EmployeeEntity employeeEntity);

}
