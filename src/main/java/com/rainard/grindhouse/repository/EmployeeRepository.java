package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    Employee findEmployeeByEmpNumberAndEmpPassword(String empNumber, String empPassword);
    Employee findEmployeeById(int id);
}