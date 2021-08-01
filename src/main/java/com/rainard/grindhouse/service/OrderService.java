package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;

import com.rainard.grindhouse.model.request.ViewOrderRequest;


import com.rainard.grindhouse.model.response.ViewOrderResponse;

import com.rainard.grindhouse.model.response.ViewOrdersResponse;

import org.springframework.http.ResponseEntity;

public interface OrderService {

    ViewOrderResponse viewOrder(ViewOrderRequest request);

    ViewOrdersResponse viewOrdersByState(ViewOrderByStateRequest request, Long employeeId);

    boolean createOrder(CreateOrderRequest request, Long id);

    ResponseEntity<Object> updateOrderState(UpdateOrderStateRequest request);

}
