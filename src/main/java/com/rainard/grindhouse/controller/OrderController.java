package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderRequest;
import com.rainard.grindhouse.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("order/view")
    public ResponseEntity<Object> viewOrder(@RequestBody ViewOrderRequest request) {
        return orderService.viewOrder(request);
    }

    @PostMapping("ordersEntity/view")
    public ResponseEntity<Object> viewOrdersByState(@RequestBody ViewOrderByStateRequest request) {
        return orderService.viewOrdersByState(request);
    }

    @PostMapping("order/create")
    public ResponseEntity<Object> createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @PatchMapping("order/update/state")
    public ResponseEntity<Object> updateOrderState(@RequestBody UpdateOrderStateRequest request) {
        return orderService.updateOrderState(request);

    }
}
