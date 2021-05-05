package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.CoffeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Long> {
}