package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findEmployeeEntityByEmployeeNumberAndAndEmployeePassword(String employeeNumber, String employeePassword);
}