package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.AuditLogEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogEntity, Long> {
}