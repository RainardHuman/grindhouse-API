package com.rainard.grindhouse.persistence.repository;
import com.rainard.grindhouse.persistence.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
}