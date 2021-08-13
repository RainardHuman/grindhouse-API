package com.rainard.grindhouse.controller;


import com.rainard.grindhouse.dto.request.EmployeeRegisterDTO;
import com.rainard.grindhouse.dto.request.EmployeeUpdatePasswordDTO;
import com.rainard.grindhouse.dto.request.EmployeeUpdateStatusDTO;

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

    private final static String EMPLOYEE_REGISTER_URL = "/employee/register";
    private final static String EMPLOYEE_UPDATE_PASSWORD_URL = "/employee/update/password";
    private final static String EMPLOYEE_UPDATE_STATUS_URL = "/employee/update/status";

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

    private static Stream<Arguments> employeeURLs() {
        return Stream.of(
            arguments(EMPLOYEE_REGISTER_URL),
            arguments(EMPLOYEE_UPDATE_PASSWORD_URL),
            arguments(EMPLOYEE_UPDATE_STATUS_URL)
        );
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void successEmployeeRegister() throws Exception {

        var employeeDTO = EmployeeRegisterDTO.builder()
            .employeeName("Rainard")
            .employeeNumber("f5384532")
            .employeePassword("password")
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeDTO)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void successEmployeeUpdatePassword() throws Exception {

        var employeeUpdatePasswordDTO = EmployeeUpdatePasswordDTO.builder()
            .employeePassword("password")
            .build();

        mockMvc.perform(post(EMPLOYEE_UPDATE_PASSWORD_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeUpdatePasswordDTO)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void successEmployeeUpdateStatus() throws Exception {

        var employeeUpdateStatusDTO = EmployeeUpdateStatusDTO.builder()
            .loggedIn(false)
            .build();

        mockMvc.perform(post(EMPLOYEE_UPDATE_STATUS_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeUpdateStatusDTO)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @ParameterizedTest
    @MethodSource("employeeURLs")
    void failNoAuthorizationHeader(final String url) throws Exception {
        mockMvc.perform(post(url)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @ParameterizedTest
    @MethodSource("blankRegisterEmployeeDetails")
    void failRegisterWithBlankTest(String employeeName, String employeeNumber, String employeePassword) throws Exception {
        var employeeDTO = EmployeeRegisterDTO.builder()
            .employeeNumber(employeeNumber)
            .employeePassword(employeePassword)
            .employeeName(employeeName)
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getContentAsString(employeeDTO))
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void failMinRegistrationPasswordLength() throws Exception {
        var employeeDTO = EmployeeRegisterDTO.builder()
            .employeeName("Rainard")
            .employeeNumber("f5384532")
            .employeePassword("passwor")
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeDTO)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void failMinUpdatePasswordLength() throws Exception {
        var employeeUpdatePasswordDTO = EmployeeUpdatePasswordDTO.builder()
            .employeePassword("passwor")
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeUpdatePasswordDTO)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

    @Test
    void failNullUpdatePasswordLength() throws Exception {
        var employeeUpdatePasswordDTO = EmployeeUpdatePasswordDTO.builder()
            .employeePassword(null)
            .build();

        mockMvc.perform(post(EMPLOYEE_REGISTER_URL)
                .header("Authorization", "0000000000x")
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(employeeUpdatePasswordDTO)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }
}
