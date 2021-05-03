package com.rainard.grindhouse.persistence.repository;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepository extends CrudRepository<AuditLogEntity, Integer> {
}