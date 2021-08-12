package com.rainard.grindhouse.controller;


import com.rainard.grindhouse.dto.request.EmployeeDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Stream;

import static com.rainard.grindhouse.util.TestUtil.UTF_8;
import static com.rainard.grindhouse.util.TestUtil.getContentAsString;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    private final String EMPLOYEE_REGISTER_URL = "/employee/register";
    private final String EMPLOYEE_UPDATE_URL = "/employee/update";

    private MockMvc mockMvc;

    @InjectMocks
    private EmployeeController employeeController;

    private static Stream<Arguments> blankRegisterEmployeeDetails() {
        return Stream.of(
            arguments("", "f5384532", "password"),
            arguments("Rainard", "", "password"),
            arguments("Rainard", "f5384532", ""),
            arguments(null, "f5384532", "password"),
            arguments("Rainard", null, "password"),
            arguments("Rainard", "f5384532", null)
        );
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void successEmployeeRegister() throws Exception {

        var employeeDTO = EmployeeDTO.builder()
            .employeeName("Rainard")
            .employeeNumber("f5384532")
            .employeePassword("password")
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeDTO)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();

    }

    @ParameterizedTest
    @MethodSource("blankRegisterEmployeeDetails")
    void registerWithBlankTest(String employeeName, String employeeNumber, String employeePassword) throws Exception {
        var employeeDTO = EmployeeDTO.builder()
            .employeeNumber(employeeNumber)
            .employeePassword(employeePassword)
            .employeeName(employeeName)
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getContentAsString(employeeDTO))
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void invalidMinPasswordLength() throws Exception {
        var employeeDTO = EmployeeDTO.builder()
            .employeeName("Rainard")
            .employeeNumber("f5384532")
            .employeePassword("passwor")
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeDTO)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
