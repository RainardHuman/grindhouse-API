package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import org.springframework.data.repository.CrudRepository;


public interface AuditLogRepository extends CrudRepository<AuditLogEntity, Long> {
}

