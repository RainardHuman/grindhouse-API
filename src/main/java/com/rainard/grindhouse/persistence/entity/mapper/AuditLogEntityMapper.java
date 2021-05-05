package com.rainard.grindhouse.persistence.entity.mapper;

import com.rainard.grindhouse.domain.model.AuditLog;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {EmployeeEntityMapper.class}
)
public interface AuditLogEntityMapper {

    AuditLogEntity map(AuditLog auditLog);

}
