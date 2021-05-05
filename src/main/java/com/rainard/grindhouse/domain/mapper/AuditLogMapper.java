package com.rainard.grindhouse.domain.mapper;

import com.rainard.grindhouse.domain.model.AuditLog;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {EmployeeMapper.class}
)
public interface AuditLogMapper {

    AuditLog map(AuditLogEntity auditLogEntity);

}
