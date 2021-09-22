package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.CustomerEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
}

