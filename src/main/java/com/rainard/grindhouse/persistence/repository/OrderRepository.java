package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.OrderEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}

