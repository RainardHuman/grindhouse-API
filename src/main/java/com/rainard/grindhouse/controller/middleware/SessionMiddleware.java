package com.rainard.grindhouse.controller.middleware;

import com.rainard.grindhouse.cache.repository.EmployeeRedisRepository;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SessionMiddleware {

    private final EmployeeRedisRepository employeeRedisRepository;
    private final EmployeeRepository employeeRepository;

    public Long isSession(String sessionToken) {
        var id = employeeRedisRepository.findById(sessionToken);
        if (Objects.isNull(id))
            return null;
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            if (employeeEntity.getUpdated().getTime() > System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(15)) {
                return  employeeEntity.getId();
            }
        }
        return null;
    }
}
