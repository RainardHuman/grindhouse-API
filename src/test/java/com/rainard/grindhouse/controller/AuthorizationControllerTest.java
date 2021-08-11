package com.rainard.grindhouse.controller;


import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.dto.response.LoginResponse;

import com.rainard.grindhouse.model.Problem;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Stream;

import static com.rainard.grindhouse.util.TestUtil.getContentAsString;
import static com.rainard.grindhouse.util.TestUtil.objectMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class AuthorizationControllerTest {

    private final String AUTH_LOGIN_URL = "/auth/login";
    private final String AUTH_LOGOUT_URL = "/auth/logout";

    private MockMvc mockMvc;

    @InjectMocks
    private AuthorisationController authorizationController;

    private static Stream<Arguments> blankLoginRequestDetails() {
        return Stream.of(
            arguments("f5384532", ""),
            arguments("", "password"),
            arguments("f5384532", null),
            arguments(null, "password"),
            arguments("", ""),
            arguments(null, null)
        );
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorizationController).build();
    }

    @Test
    void shouldReturnDefaultMessage() throws Exception {

        var loginRequest = LoginRequest.builder()
            .employeeNumber("employeeNumber")
            .employeePassword("employeePassword")
            .build();

        var loginResponse = LoginResponse.builder()
            .employeeName("Rainard")
            .sessionToken("0000000000000x")
            .build();

        System.out.println(getContentAsString(loginRequest));

        mockMvc.perform(post(AUTH_LOGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(loginRequest)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(getContentAsString(loginResponse)))
            .andReturn();

    }

    @ParameterizedTest
    @MethodSource("blankLoginRequestDetails")
    void loginBlankTest(String employeeNumber, String employeePassword) throws Exception {
        var loginRequest = LoginRequest.builder()
            .employeeNumber(employeeNumber)
            .employeePassword(employeePassword)
            .build();

        var mvcResult = mockMvc.perform(post(AUTH_LOGIN_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getContentAsString(loginRequest))
            )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isBadRequest())
            .andReturn();

        var expectedResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Problem.class);

        assertTrue(expectedResult.getDetail().contains("can not be null or blank"));
    }

}
