package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.request.CreateOrderRequest;
import com.rainard.grindhouse.model.request.UpdateOrderStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderByStateRequest;
import com.rainard.grindhouse.model.request.ViewOrderRequest;
import com.rainard.grindhouse.model.response.ViewOrderResponse;
import com.rainard.grindhouse.model.response.ViewOrdersResponse;
import com.rainard.grindhouse.persistence.repository.CoffeeRepository;
import com.rainard.grindhouse.persistence.repository.CustomerRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;
import com.rainard.grindhouse.persistence.repository.OrderRepository;
import com.rainard.grindhouse.util.MapUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CoffeeRepository coffeeRepository;
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;
    private final MapUtil mapper = new MapUtil();

    @Override
    public ViewOrderResponse viewOrder(final ViewOrderRequest request) {
        return null;
    }

    @Override
    public ViewOrdersResponse viewOrdersByState(final ViewOrderByStateRequest request, final Long employeeId) {
        return null;
    }

    @Override
    public boolean createOrder(final CreateOrderRequest request, final Long id) {
        return false;
    }

    @Override
    public ResponseEntity<Object> updateOrderState(final UpdateOrderStateRequest request) {
        return null;
    }

//    @Override
//    public ResponseEntity<Object> viewOrder(ViewOrderRequest request) {
//        var optionalOrdersEntity = orderRepository.findById(request.getOrderId());
//        if (optionalOrdersEntity.isPresent()) {
//            var ordersEntity = optionalOrdersEntity.get();
//            return ResponseEntity.ok(ViewOrderResponse.builder()
//                .order(mapper.mapOrder(ordersEntity))
//                .build());
//        } else
//            return notFoundResponse("Could not find order");
//    }
//
//    @Override
//    public ResponseEntity<Object> viewOrdersByState(ViewOrderByStateRequest request, Long employeeId) {
//
//        List<String> acceptedStates = Arrays.asList("inprogress", "history");
//
//        if (acceptedStates.contains(request.getState())) {
//
//            var ordersEntities = orderRepository.findAllByEmployee_IdAndState(employeeId,request.getState());
//            return ordersEntities.isEmpty() ?
//                notFoundResponse("Could not retrieve orders of state: " + request.getState()) :
//                ResponseEntity.ok(ViewOrdersResponse.builder()
//                    .orders(mapper.mapOrders(ordersEntities))
//                    .build());
//        } else
//            return badResponse();
//
//    }
//
//    @Override
//    public ResponseEntity<Object> createOrder(CreateOrderRequest request, Long id) {
//
//        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
//
//        if (!request.getItems().isEmpty() &&
//            Objects.nonNull(request.getCustomer())) {
//
//            CustomerEntity customerEntity = customerRepository.findCustomerEntityByCustomerNameAndAndCustomerContact(request.getCustomer().getName(), request.getCustomer().getContact());
//
//            if (Objects.isNull(customerEntity)) {
//                customerEntity = customerRepository.save(CustomerEntity.builder()
//                    .customerName(request.getCustomer().getName())
//                    .customerContact(request.getCustomer().getContact())
//                    .created(Timestamp.from(Instant.now()))
//                    .isValid(true)
//                    .build());
//            }
//
//            OrdersEntity ordersEntity = orderRepository.save(OrdersEntity.builder()
//                .created(Timestamp.from(Instant.now()))
//                .version(1)
//                .state("inprogress")
//                .employee(employeeEntity)
//                .customer(customerEntity)
//                .build());
//
//            List<ItemEntity> items = generateItems(request.getItems(), ordersEntity);
//            if (Objects.isNull(items))
//                return notFoundResponse("Could not find coffee");
//
//            ordersEntity.setItems(items);
//            orderRepository.save(ordersEntity);
//
//            return ResponseEntity.ok("Created");
//
//        } else
//            return badResponse();
//    }
//
//    private List<ItemEntity> generateItems(List<CapturedItem> capturedItems, OrdersEntity ordersEntity) {
//        List<ItemEntity> items = new ArrayList<>();
//
//        for (CapturedItem item : capturedItems) {
//            var coffeeEntity = coffeeRepository.findById(item.getCoffeeId());
//            if (coffeeEntity.isEmpty()) {
//                return null;
//            } else
//                items.add(ItemEntity.builder()
//                    .created(Timestamp.from(Instant.now()))
//                    .quantity(item.getQuantity())
//                    .orderVersion(1)
//                    .cream(item.isCream())
//                    .milk(item.isMilk())
//                    .sugar(item.isSugar())
//                    .coffee(coffeeEntity.get())
//                    .order(ordersEntity)
//                    .build());
//        }
//        return items;
//    }
//
//    @Override
//    public ResponseEntity<Object> updateOrderState(UpdateOrderStateRequest request) {
//        var optionalOrdersEntity = orderRepository.findById(request.getOrderId());
//
//        if (optionalOrdersEntity.isPresent()) {
//            var order = optionalOrdersEntity.get();
//            order.setState(request.getState());
//            orderRepository.save(order);
//
//            return ResponseEntity.ok("Successfully changed state.");
//        } else
//            return badResponse();
//    }
//
//    private ResponseEntity<Object> notFoundResponse(String message) {
//        return ResponseEntity.status(404).body(FailResponse.builder()
//            .error("Not Found")
//            .message(message)
//            .build());
//    }
//
//    private ResponseEntity<Object> badResponse() {
//        return ResponseEntity.status(400).body(FailResponse.builder()
//            .error("Failed")
//            .message("Please enter a valid request body.")
//            .build());
//    }
}
