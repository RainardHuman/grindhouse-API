package com.rainard.grindhouse.util;

import com.rainard.grindhouse.model.domain.Customer;
import com.rainard.grindhouse.model.domain.Employee;
import com.rainard.grindhouse.model.domain.Item;
import com.rainard.grindhouse.model.domain.Order;
import com.rainard.grindhouse.model.domain.Product;
import com.rainard.grindhouse.persistence.entity.ProductEntity;
import com.rainard.grindhouse.persistence.entity.CustomerEntity;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.entity.ItemEntity;
import com.rainard.grindhouse.persistence.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MapUtil {
    public Product mapCoffee(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .prodName(productEntity.getCoffeeName())
                .prodDesc(productEntity.getCoffeeDescription())
                .prodPrice(productEntity.getCoffeePrice())
                .hasMilk(productEntity.getHasMilk())
                .hasCream(productEntity.getHasCream())
                .hasSugar(productEntity.getHasSugar())
                .build();
    }

    public List<Product> mapCoffees(List<ProductEntity> productEntityList) {
        List<Product> products = new ArrayList<>();
        productEntityList.forEach(productEntity -> products.add(mapCoffee(productEntity)));
        return products;
    }

    public Customer mapCustomer(CustomerEntity customerEntity) {
        return Customer.builder()
            .name(customerEntity.getCustomerName())
            .contact(customerEntity.getCustomerContact())
            .build();
    }

    public Employee mapEmployee(EmployeeEntity employeeEntity) {
        return Employee.builder()
            .name(employeeEntity.getEmployeeName())
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

    public Order mapOrder(OrderEntity orderEntity) {
        return Order.builder()
            .id(orderEntity.getId())
            .created(orderEntity.getCreated())
            .lastUpdated(orderEntity.getUpdated())
            .state(orderEntity.getState())
            .version(orderEntity.getVersion())
            .customer(mapCustomer(orderEntity.getCustomer()))
            .employee(Objects.isNull(orderEntity.getEmployee()) ? null : mapEmployee(orderEntity.getEmployee()))
            .items(mapItems(orderEntity.getItems()))
            .build();
    }

    public List<Order> mapOrders(List<OrderEntity> orderEntityList) {
        List<Order> orders = new ArrayList<>();
        orderEntityList.forEach(ordersEntity -> orders.add(mapOrder(ordersEntity)));
        return orders;
    }


    public ProductEntity mapCoffeeEntity(Product coffeeEntity) {
        return ProductEntity.builder()
            .prodName(coffeeEntity.getProdName())
            .coffeeDescription(coffeeEntity.getProdDesc())
            .coffeePrice(coffeeEntity.getProdPrice())
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
            .product(mapCoffeeEntity(itemEntity.getCoffee()))
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

    public OrderEntity mapOrdersEntity(Order ordersEntity) {
        return OrderEntity.builder()
            .state(ordersEntity.getState())
            .version(ordersEntity.getVersion())
            .customer(mapCustomerEntity(ordersEntity.getCustomer()))
            .employee(mapEmployeeEntity(ordersEntity.getEmployee()))
            .items(mapItemsEntityList(ordersEntity.getItems()))
            .build();
    }
}
