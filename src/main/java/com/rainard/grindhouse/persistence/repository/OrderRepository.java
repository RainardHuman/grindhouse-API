package com.rainard.grindhouse.persistence.repository;
import com.rainard.grindhouse.persistence.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrdersEntity, Integer> {
    OrdersEntity findOrdersById(int id);
    List<OrdersEntity> findAllByFkEmpIdAndStateEquals(int empId, String state);
}