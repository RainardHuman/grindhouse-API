package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.table.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {
}