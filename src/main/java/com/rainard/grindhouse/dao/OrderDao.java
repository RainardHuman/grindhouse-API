package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Orders, Integer> {
}