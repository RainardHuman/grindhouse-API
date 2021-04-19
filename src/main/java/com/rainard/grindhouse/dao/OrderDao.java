package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.table.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Orders, Integer> {
}