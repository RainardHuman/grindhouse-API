package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.OrdersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrdersEntity, Long> {
    List<OrdersEntity> findAllByEmployee_IdAndState(Long employeeId, String state);
}