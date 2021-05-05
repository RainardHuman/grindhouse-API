package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.CustomerEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}