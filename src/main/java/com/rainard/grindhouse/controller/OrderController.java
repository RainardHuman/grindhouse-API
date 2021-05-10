package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.controller.middleware.SessionMiddleware;
import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderRequest;
import com.rainard.grindhouse.service.OrderService;
import com.rainard.grindhouse.util.AuthUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final AuthUtil authUtil = new AuthUtil();
    private final SessionMiddleware sessionMiddleware;

    @PostMapping("order/view")
    public ResponseEntity<Object> viewOrder(@RequestBody ViewOrderRequest request) {
        return middleware(request.getSessionToken(), orderService.viewOrder(request));
    }

    @PostMapping("ordersEntity/view")
    public ResponseEntity<Object> viewOrdersByState(@RequestBody ViewOrderByStateRequest request) {
        return middleware(request.getSessionToken(), orderService.viewOrdersByState(request));
    }

    @PostMapping("order/create")
    public ResponseEntity<Object> createOrder(@RequestBody CreateOrderRequest request) {
        var id = sessionMiddleware.isSession(request.getSessionToken());
        return Objects.isNull(id) ? authUtil.unauthorisedUser() :  orderService.createOrder(request, sessionMiddleware.isSession(request.getSessionToken()));
    }

    @PatchMapping("order/update/state")
    public ResponseEntity<Object> updateOrderState(@RequestBody UpdateOrderStateRequest request) {
        return middleware(request.getSessionToken(), orderService.updateOrderState(request));
    }

    private ResponseEntity<Object> middleware(String sessionToken,ResponseEntity<Object> response) {
        var id = sessionMiddleware.isSession(sessionToken);
        return Objects.isNull(id) ? authUtil.unauthorisedUser() : response;
    }
}
