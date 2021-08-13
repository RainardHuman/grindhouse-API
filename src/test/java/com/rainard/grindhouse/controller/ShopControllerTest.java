package com.rainard.grindhouse.controller;


import com.rainard.grindhouse.dto.request.ShopNewDTO;
import com.rainard.grindhouse.service.ShopServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
class ShopControllerTest {

    private final String SHOP_NEW = "/shop/new";

    private MockMvc mockMvc;

    @InjectMocks
    private ShopController shopController;

    @Mock
    private ShopServiceImpl shopServiceImpl;

    private static Stream<Arguments> blankNewShopDetails() {
        return Stream.of(
            arguments("", null),
            arguments(null, null)
        );
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(shopController).build();
    }

    @Test
    void validNewShopRequest() throws Exception {

        var newShop = ShopNewDTO.builder()
            .name("New Coffee Shop")
            .build();

        mockMvc.perform(post(SHOP_NEW)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(newShop)))
            .andDo(print())
            .andExpect(status().isOk())
            .andReturn();
    }

    @ParameterizedTest
    @MethodSource("blankNewShopDetails")
    void invalidNewShopRequest(String name) throws Exception {

        var newShop = ShopNewDTO.builder()
            .name(name)
            .build();

        mockMvc.perform(post(SHOP_NEW)
                .characterEncoding(UTF_8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getContentAsString(newShop)))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andReturn();
    }

}
