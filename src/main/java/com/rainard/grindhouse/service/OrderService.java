package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.OrderWithItems;

import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<Object> viewOrder(Long orderId);

    ResponseEntity<Object> viewInProgressOrders(Long employeeId, String state);

    ResponseEntity<Object> createOrder(OrderWithItems orderWithItems);

    ResponseEntity<Object> updateOrderState(Long orderId, String state);

}
