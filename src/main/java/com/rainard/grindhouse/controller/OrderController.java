package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/test")
    public String test() {
        return orderDao.findById(1).get().toString();
    }
}
