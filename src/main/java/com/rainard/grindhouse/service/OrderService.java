package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;

import com.rainard.grindhouse.model.request.ViewOrderRequest;

import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<Object> viewOrder(ViewOrderRequest request);

    ResponseEntity<Object> viewOrdersByState(ViewOrderByStateRequest request);

    ResponseEntity<Object> createOrder(CreateOrderRequest request, Long id);

    ResponseEntity<Object> updateOrderState(UpdateOrderStateRequest request);

}
