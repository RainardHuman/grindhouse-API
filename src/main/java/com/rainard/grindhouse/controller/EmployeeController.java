package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dto.request.EmployeeDTO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Object> update(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok().build();
    }
}
