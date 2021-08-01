package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<ProductEntity, Long> {
}