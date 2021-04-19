package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("order/view/{emp_id}/order_id")
    public String viewOrder(@RequestParam String emp_id, @RequestParam String order_id) {
        return "";
    }

    @GetMapping("orders/view/inprogress/{emp_id}")
    public String viewInProgressOrders(@RequestParam String emp_id) {
        return "";
    }

    @GetMapping("orders/view/history/{emp_id}")
    public String viewHistoryOrders(@RequestParam String emp_id) {
        return "";
    }

    @GetMapping("orders/view/admin/{emp_id}")
    public String viewAdminOrders(@RequestParam String emp_id) {
        return "";
    }

    @PostMapping("order/create")
    public String createOrder() {
        return "";
    }

    @PutMapping("order/update")
    public String updateOrder() {
        return "";
    }

    @PatchMapping("order/update/state")
    public String updateOrderState() {
        return "";
    }
}
