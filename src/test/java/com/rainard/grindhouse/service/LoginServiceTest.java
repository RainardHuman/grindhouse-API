package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.repository.AuditLogRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @InjectMocks
    private AuthorisationServiceImpl authorisationService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private AuditLogRepository auditLogRepository;

    @Test
    void loginValidUser() {

        var employeeRainard = LoginRequest.builder()
            .employeeNumber("F5384532")
            .employeePassword("password")
            .build();

        assertNotNull(employeeRepository);

        when(employeeRepository.findByEmpNumberAndEmpPassword(anyString(), anyString()))
            .thenReturn(EmployeeEntity.builder()
                .empId(1L)
                .empName("Rainard")
                .empNumber("F5384532")
                .empPassword("password")
                .created(Timestamp.from(Instant.now()))
                .isLoggedIn(false)
                .build());

        var loginResponse = authorisationService.login(employeeRainard);

        assertEquals("Rainard", loginResponse.getEmployeeName());
        assertEquals("00000000000x", loginResponse.getSessionToken());

    }

}
