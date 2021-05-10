package com.rainard.grindhouse;

import com.rainard.grindhouse.cache.repository.EmployeeRedisRepository;

import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GrindhouseApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(GrindhouseApplication.class, args);
        var repository = context.getBean(EmployeeRedisRepository.class);
        repository.init();
    }

}
