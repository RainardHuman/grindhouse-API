package com.rainard.grindhouse.service;

import com.rainard.grindhouse.domain.mapper.ItemMapper;
import com.rainard.grindhouse.domain.mapper.OrdersMapper;
import com.rainard.grindhouse.model.OrderWithItems;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.persistence.entity.mapper.OrdersEntityMapper;
import com.rainard.grindhouse.persistence.repository.ItemRepository;
import com.rainard.grindhouse.persistence.repository.OrderRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    // This is injected with constructor injection by spring dependency injection.
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final OrdersMapper ordersMapper;
    private final ItemMapper itemMapper;
    private final OrdersEntityMapper ordersEntityMapper;

    @Override
    public ResponseEntity<Object> viewOrder(@RequestParam Long orderId) {
        var optionalOrdersEntity = orderRepository.findById(orderId);

        if (optionalOrdersEntity.isPresent()) {
            var order = ordersMapper.map(optionalOrdersEntity.get());

            return ResponseEntity
                .ok(OrderWithItems.builder()
                    .order(order)
                    .build());
        } else {
            return failResponse("Login Failed", "Incorrect employee number or password.");
        }
    }

    @Override
    public ResponseEntity<Object> viewInProgressOrders(final Long employeeId, final String state) {
        var ordersEntities = orderRepository.findAllByEmployee_IdAndState(employeeId, state);
        if (ordersEntities.isEmpty()) {
            return failResponse("Orders View Failed", "Could not retrieve ordersEntity of state: " + state);
        } else {
            // this should be mapped to a dto
            return ResponseEntity.ok(ordersEntities);
        }
    }

    @Override
    public ResponseEntity<Object> createOrder(OrderWithItems orderWithItems) {
        if (Objects.nonNull(orderWithItems.getOrder()) && !orderWithItems.getOrder().getItems().isEmpty()) {

            orderRepository.save(ordersEntityMapper.map(orderWithItems.getOrder()));

            return ResponseEntity.ok("Successfully created");
        } else {
            return failResponse("Create Failed", "Could not create order, check order and orderItems.");
        }
    }

    @Override
    public ResponseEntity<Object> updateOrderState(final Long orderId, final String state) {
        var optionalOrdersEntity = orderRepository.findById(orderId);
        if (optionalOrdersEntity.isPresent()) {
            var order = ordersMapper.map(optionalOrdersEntity.get());

            order.setState(state);
            orderRepository.save(ordersEntityMapper.map(order));

            return ResponseEntity.ok("Successfully changed state.");
        } else {
            return failResponse("Update Failed", "Could not update order state.");
        }
    }

    private ResponseEntity<Object> failResponse(String error, String message) {
        return ResponseEntity.status(400).body(FailResponse.builder()
            .error(error)
            .message(message)
            .build());
    }
}
