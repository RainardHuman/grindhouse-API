package com.rainard.grindhouse.controller;


import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.dto.response.LoginResponse;

import com.rainard.grindhouse.model.Problem;

import com.rainard.grindhouse.service.AuthorisationServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Stream;

import static com.rainard.grindhouse.util.TestUtil.UTF_8;
import static com.rainard.grindhouse.util.TestUtil.compareJsonValue;
import static com.rainard.grindhouse.util.TestUtil.getContentAsString;
import static com.rainard.grindhouse.util.TestUtil.objectMapper;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class AuthorizationControllerTest {

    private final String AUTH_LOGIN_URL = "/auth/login";
    private final String AUTH_LOGOUT_URL = "/auth/logout";

    private MockMvc mockMvc;

    @InjectMocks
    private AuthorisationController authorizationController;

    @Mock
    private AuthorisationServiceImpl authorisationService;

    private static Stream<Arguments> blankLoginRequestDetails() {
        return Stream.of(
            arguments("f5384532", ""),
            arguments("", "password"),
            arguments("f5384532", null),
            arguments(null, "password")
        );
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorizationController).build();
    }


    @Test
    void successLogin() throws Exception {

        var loginRequest = LoginRequest.builder()
            .employeeNumber("f5384532")
            .employeePassword("password")
            .build();

        mockMvc.perform(post(AUTH_LOGIN_URL)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(loginRequest)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @Test
    void successLogout() throws Exception {
        mockMvc.perform(get(AUTH_LOGOUT_URL)
                .header("Authorization","000000000x"))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @ParameterizedTest
    @MethodSource("blankLoginRequestDetails")
    void loginWithBlankTest(String employeeNumber, String employeePassword) throws Exception {
        var loginRequest = LoginRequest.builder()
            .employeeNumber(employeeNumber)
            .employeePassword(employeePassword)
            .build();

        mockMvc.perform(post(AUTH_LOGIN_URL)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getContentAsString(loginRequest))
            )
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
