package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.OrderWithItems;
import com.rainard.grindhouse.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("order/view")
    public ResponseEntity<Object> viewOrder(@RequestParam Long orderId) {
        return orderService.viewOrder(orderId);
    }

    @GetMapping("ordersEntity/view")
    public ResponseEntity<Object> viewInProgressOrders(@RequestParam Long employeeId, @RequestParam String state) {
        return orderService.viewInProgressOrders(employeeId, state);
    }

    @PostMapping("order/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderWithItems orderWithItems) {
        return orderService.createOrder(orderWithItems);
    }

    @PatchMapping("order/update/state")
    public ResponseEntity<Object> updateOrderState(@RequestParam Long orderId, @RequestParam String state) {
        return orderService.updateOrderState(orderId, state);
    }
}
