package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.OrderWithItems;
import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderRequest;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.persistence.repository.OrderRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<Object> viewOrder(ViewOrderRequest request) {

        //session token check = true
        //would retrieve employee id
        if (isValidSession()) {
            var optionalOrdersEntity = orderRepository.findById(request.getOrderId());

            if (optionalOrdersEntity.isPresent()) {
                var order = optionalOrdersEntity.get();

                return ResponseEntity
                    .ok(OrderWithItems.builder()
                        .order(order)
                        .build());
            } else {
                return failResponse("No Order Found", "Could not find any orders by given id.");
            }
        } else {
            return failResponse("Unauthorized", "Please log in and retry");
        }
    }



    @Override
    public ResponseEntity<Object> viewOrdersByState(ViewOrderByStateRequest request) {
        List<String> acceptedStates = Arrays.asList("inprogress", "history");
            if (acceptedStates.contains(request.getState())) {
                var ordersEntities = orderRepository.findAllByEmployee_IdAndState(Long.valueOf("1"),request.getState());
                return ordersEntities.isEmpty() ?
                    failResponse("Orders View Failed", "Could not retrieve ordersEntity of state: " + request.getState()) :
                    ResponseEntity.ok(ordersEntities);
            } else {
                return failResponse("Unknown state", "Could not retrieve any orders of state: " + request.getState());
            }
    }


    @Override
    public ResponseEntity<Object> createOrder(CreateOrderRequest request) {
        if (Objects.nonNull(request.getOrderId()) && !request.) {
            orderRepository.save(orderWithItems.getOrder());
            return ResponseEntity.ok("Successfully created");
        } else {
            return failResponse("Create Failed", "Could not create order, check order and orderItems.");
        }
    }

    @Override
    public ResponseEntity<Object> updateOrderState(@RequestBody UpdateOrderStateRequest request) {
        //session token check = true
        //would retrieve employee id
        if (true) {
            var optionalOrdersEntity = orderRepository.findById(request.getOrderId());
            if (optionalOrdersEntity.isPresent()) {
                var order = optionalOrdersEntity.get();

                order.setState(request.getState());
                orderRepository.save(order);

                return ResponseEntity.ok("Successfully changed state.");
            } else {
                return failResponse("Update Failed", "Could not update order state.");
            }
        } else {
            return failResponse("Unauthorized", "Please log in and retry");
        }

    }

    private ResponseEntity<Object> failResponse(String error, String message) {
        return ResponseEntity.status(400).body(FailResponse.builder()
            .error(error)
            .message(message)
            .build());
    }


}
