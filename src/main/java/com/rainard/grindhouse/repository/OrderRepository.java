package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    Orders findOrdersById(int id);
    List<Orders> findAllByFkEmpIdAndStateEquals(int empId, String state);
}