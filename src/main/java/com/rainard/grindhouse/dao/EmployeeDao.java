package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}