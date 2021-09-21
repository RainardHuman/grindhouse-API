package com.rainard.grindhouse;

import com.rainard.grindhouse.cache.repository.EmployeeRedisRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GrindHouseApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(GrindHouseApplication.class, args);
        var repository = context.getBean(EmployeeRedisRepository.class);
        repository.init();
    }
}
