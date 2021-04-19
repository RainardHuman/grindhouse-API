package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
}