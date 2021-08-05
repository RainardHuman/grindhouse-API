package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    EmployeeEntity findByEmpNumberAndEmpPassword(String empNumber, String empPassword);
}

