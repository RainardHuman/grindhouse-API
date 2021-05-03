package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.OrderWithItems;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.persistence.entity.OrdersEntity;
import com.rainard.grindhouse.persistence.repository.ItemRepository;
import com.rainard.grindhouse.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("order/view")
    public ResponseEntity<Object> viewOrder(@RequestParam int orderId) {
        OrdersEntity ordersEntity = orderRepository.findOrdersById(orderId);
        if (Objects.nonNull(ordersEntity)) {
            OrderWithItems orderWithItems = OrderWithItems.builder()
                    .order(ordersEntity)
                    .orderItems(itemRepository.findAllByFkOrderId(ordersEntity.getId()))
                    .build();
            return ResponseEntity.ok(orderWithItems);
        } else {
            return failResponse("Login Failed","Incorrect employee number or password.");
        }
    }

    @GetMapping("ordersEntity/view")
    public ResponseEntity<Object> viewInProgressOrders(@RequestParam int empId, @RequestParam String state) {
        List<OrdersEntity> ordersEntity = orderRepository.findAllByFkEmpIdAndStateEquals(empId, state);
        if (ordersEntity.isEmpty()) {
            return failResponse("Orders View Failed","Could not retrieve ordersEntity of state: " + state);
        } else {
            return ResponseEntity.ok(ordersEntity);
        }
    }

    @PostMapping("order/create")
    public ResponseEntity<Object> createOrder(@RequestBody OrderWithItems orderWithItems) {
        if (Objects.nonNull(orderWithItems.getOrder()) && !orderWithItems.getOrderItemEntities().isEmpty()) {
            OrdersEntity ordersEntity = orderRepository.save(orderWithItems.getOrder());
            orderWithItems.getOrderItemEntities().forEach(item -> item.setFkOrderId(ordersEntity.getId()));
            itemRepository.saveAll(orderWithItems.getOrderItemEntities());
            return ResponseEntity.ok("Successfully created");
        } else {
            return failResponse("Create Failed","Could not create order, check order and orderItems.");
        }
    }

    @PatchMapping("order/update/state")
    public ResponseEntity<Object> updateOrderState(@RequestParam int orderId, @RequestParam String state) {
        OrdersEntity ordersEntity = orderRepository.findOrdersById(orderId);
        if (Objects.nonNull(ordersEntity)) {
            ordersEntity.setState(state);
            orderRepository.save(ordersEntity);
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
