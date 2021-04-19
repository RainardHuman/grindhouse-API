package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.OrderWithItems;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.model.table.Orders;
import com.rainard.grindhouse.repository.ItemRepository;
import com.rainard.grindhouse.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("order/view")
    public ResponseEntity<Object> viewOrder(@RequestParam int orderId) {
        Orders orders = orderRepository.findOrdersById(orderId);
        if (Objects.nonNull(orders)) {
            OrderWithItems orderWithItems = OrderWithItems.builder()
                    .order(orders)
                    .orderItems(itemRepository.findAllByFkOrderId(orders.getId()))
                    .build();
            return ResponseEntity.ok(orderWithItems);
        } else {
            return failResponse("Login Failed","Incorrect employee number or password.");
        }
    }

    @GetMapping("orders/view")
    public ResponseEntity<Object> viewInProgressOrders(@RequestParam int empId, @RequestParam String state) {
        List<Orders> orders = orderRepository.findAllByFkEmpIdAndStateEquals(empId, state);
        if (orders.isEmpty()) {
            return failResponse("Orders View Failed","Could not retrieve orders of state: " + state);
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @PostMapping("order/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderWithItems orderWithItems) {
        if (Objects.nonNull(orderWithItems.getOrder()) && !orderWithItems.getOrderItems().isEmpty()) {
            Orders orders = orderRepository.save(orderWithItems.getOrder());
            orderWithItems.getOrderItems().forEach(item -> item.setFkOrderId(orders.getId()));
            itemRepository.saveAll(orderWithItems.getOrderItems());
            return ResponseEntity.ok("Successfully created");
        } else {
            return failResponse("Create Failed","Could not create order, check order and orderItems.");
        }
    }

    @PatchMapping("order/update/state")
    public ResponseEntity<Object> updateOrderState(@RequestParam int orderId, @RequestParam String state) {
        Orders orders = orderRepository.findOrdersById(orderId);
        if (Objects.nonNull(orders)) {
            orders.setState(state);
            orderRepository.save(orders);
            return ResponseEntity.ok("Successfully changed state.");
        } else {
            return failResponse("Update Failed","Could not update order state.");
        }
    }

    private ResponseEntity<Object> failResponse(String error, String message) {
        return ResponseEntity.status(400).body(FailResponse.builder()
                .error(error)
                .message(message)
                .build());
    }
}
