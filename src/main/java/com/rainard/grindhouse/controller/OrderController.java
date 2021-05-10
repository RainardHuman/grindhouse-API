package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderRequest;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;
import com.rainard.grindhouse.service.OrderService;

import com.rainard.grindhouse.util.AuthUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private AuthUtil authUtil = new AuthUtil();
    private final EmployeeRepository employeeRepository;

    @PostMapping("order/view")
    public ResponseEntity<Object> viewOrder(@RequestBody ViewOrderRequest request) {
        var employee = employeeRepository.findEmployeeEntityByEmployeeNumberAndAndEmployeePassword("5384532","password").get();
        return Objects.isNull(employee) ? authUtil.unauthorisedUser() : orderService.viewOrder(request);
    }

    @PostMapping("ordersEntity/view")
    public ResponseEntity<Object> viewOrdersByState(@RequestBody ViewOrderByStateRequest request) {
        var employee = employeeRepository.findEmployeeEntityByEmployeeNumberAndAndEmployeePassword("5384532","password").get();
        return Objects.isNull(employee) ? authUtil.unauthorisedUser() : orderService.viewOrdersByState(request);
    }

    @PostMapping("order/create")
    public ResponseEntity<Object> createOrder(@RequestBody CreateOrderRequest request) {
        var employee = employeeRepository.findEmployeeEntityByEmployeeNumberAndAndEmployeePassword("5384532","password").get();
        return Objects.isNull(employee) ? authUtil.unauthorisedUser() : orderService.createOrder(request, employee);
    }

    @PatchMapping("order/update/state")
    public ResponseEntity<Object> updateOrderState(@RequestBody UpdateOrderStateRequest request) {
        var employee = employeeRepository.findEmployeeEntityByEmployeeNumberAndAndEmployeePassword("5384532","password").get();
        return Objects.isNull(employee) ? authUtil.unauthorisedUser() : orderService.updateOrderState(request);
    }
}
