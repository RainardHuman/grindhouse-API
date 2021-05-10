package com.rainard.grindhouse.util;

import com.rainard.grindhouse.model.domain.Coffee;
import com.rainard.grindhouse.model.domain.Customer;
import com.rainard.grindhouse.model.domain.Employee;
import com.rainard.grindhouse.model.domain.Item;
import com.rainard.grindhouse.model.domain.Order;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import com.rainard.grindhouse.persistence.entity.CustomerEntity;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.entity.ItemEntity;
import com.rainard.grindhouse.persistence.entity.OrdersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MapUtil {
    public Coffee mapCoffee(CoffeeEntity coffeeEntity) {
        return Coffee.builder()
                .name(coffeeEntity.getCoffeeName())
                .description(coffeeEntity.getCoffeeDescription())
                .price(coffeeEntity.getCoffeePrice())
                .hasMilk(coffeeEntity.getHasMilk())
                .hasCream(coffeeEntity.getHasCream())
                .hasSugar(coffeeEntity.getHasSugar())
                .build();
    }

    public List<Coffee> mapCoffees(List<CoffeeEntity> coffeeEntityList) {
        List<Coffee> coffees = new ArrayList<>();
        coffeeEntityList.forEach( coffeeEntity -> coffees.add(mapCoffee(coffeeEntity)));
        return coffees;
    }

    public Customer mapCustomer(CustomerEntity customerEntity) {
        return Customer.builder()
            .name(customerEntity.getCustomerName())
            .contact(customerEntity.getCustomerContact())
            .build();
    }

    public Employee mapEmployee(EmployeeEntity employeeEntity) {
        return Employee.builder()
            .id(employeeEntity.getId())
            .name(employeeEntity.getEmployeeName())
            .isLoggedIn(employeeEntity.getIsLoggedIn())
            .build();
    }

    public Item mapItem(ItemEntity itemEntity) {
        return Item.builder()
            .coffee(mapCoffee(itemEntity.getCoffee()))
            .milk(itemEntity.getMilk())
            .cream(itemEntity.getCream())
            .sugar(itemEntity.getSugar())
            .orderVersion(itemEntity.getOrderVersion())
            .quantity(itemEntity.getQuantity())
            .build();
    }

    public List<Item> mapItems(List<ItemEntity> itemEntityList) {
        List<Item> items = new ArrayList<>();
        itemEntityList.forEach( itemEntity -> items.add(mapItem(itemEntity)));
        return items;
    }

    public Order mapOrder(OrdersEntity ordersEntity) {
        return Order.builder()
            .id(ordersEntity.getId())
            .created(ordersEntity.getCreated())
            .lastUpdated(ordersEntity.getUpdated())
            .state(ordersEntity.getState())
            .version(ordersEntity.getVersion())
            .customer(mapCustomer(ordersEntity.getCustomer()))
            .employee(Objects.isNull(ordersEntity.getEmployee()) ? null : mapEmployee(ordersEntity.getEmployee()))
            .items(mapItems(ordersEntity.getItems()))
            .build();
    }

    public List<Order> mapOrders(List<OrdersEntity> ordersEntityList) {
        List<Order> orders = new ArrayList<>();
        ordersEntityList.forEach( ordersEntity -> orders.add(mapOrder(ordersEntity)));
        return orders;
    }


    public CoffeeEntity mapCoffeeEntity(Coffee coffeeEntity) {
        return CoffeeEntity.builder()
            .coffeeName(coffeeEntity.getName())
            .coffeeDescription(coffeeEntity.getDescription())
            .coffeePrice(coffeeEntity.getPrice())
            .hasMilk(coffeeEntity.getHasMilk())
            .hasCream(coffeeEntity.getHasCream())
            .hasSugar(coffeeEntity.getHasSugar())
            .build();
    }

    public CustomerEntity mapCustomerEntity(Customer customerEntity) {
        return CustomerEntity.builder()
            .customerName(customerEntity.getName())
            .customerContact(customerEntity.getContact())
            .build();
    }

    public EmployeeEntity mapEmployeeEntity(Employee employeeEntity) {
        return EmployeeEntity.builder()
            .id(employeeEntity.getId())
            .employeeName(employeeEntity.getName())
            .isLoggedIn(employeeEntity.getIsLoggedIn())
            .build();
    }

    public ItemEntity mapItemEntity(Item itemEntity) {
        return ItemEntity.builder()
            .coffee(mapCoffeeEntity(itemEntity.getCoffee()))
            .milk(itemEntity.getMilk())
            .cream(itemEntity.getCream())
            .sugar(itemEntity.getSugar())
            .orderVersion(itemEntity.getOrderVersion())
            .quantity(itemEntity.getQuantity())
            .build();
    }

    public List<ItemEntity> mapItemsEntityList(List<Item> entityList) {
        List<ItemEntity> items = new ArrayList<>();
        entityList.forEach( itemEntity -> items.add(mapItemEntity(itemEntity)));
        return items;
    }

    public OrdersEntity mapOrdersEntity(Order ordersEntity) {
        return OrdersEntity.builder()
            .state(ordersEntity.getState())
            .version(ordersEntity.getVersion())
            .customer(mapCustomerEntity(ordersEntity.getCustomer()))
            .employee(mapEmployeeEntity(ordersEntity.getEmployee()))
            .items(mapItemsEntityList(ordersEntity.getItems()))
            .build();
    }
}
