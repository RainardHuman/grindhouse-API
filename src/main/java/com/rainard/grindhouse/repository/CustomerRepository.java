package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}