package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dao.EmployeeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
public class AuthController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/auth/login")
    public String login(@RequestParam String emp_number, @RequestParam String emp_password) {
        return "";
    }

    @GetMapping("/auth/logout")
    public String logout(@RequestBody int emp_id) {
        return "";
    }
}
