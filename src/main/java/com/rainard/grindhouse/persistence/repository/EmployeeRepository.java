package com.rainard.grindhouse.persistence.repository;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {


    EmployeeEntity findEmployeeByEmpNumberAndEmpPassword(String empNumber, String empPassword);
    EmployeeEntity findEmployeeById(int id);
}