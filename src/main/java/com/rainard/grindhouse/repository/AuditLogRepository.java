package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.AuditLog;
import org.springframework.data.repository.CrudRepository;

public interface AuditLogRepository extends CrudRepository<AuditLog, Integer> {
}