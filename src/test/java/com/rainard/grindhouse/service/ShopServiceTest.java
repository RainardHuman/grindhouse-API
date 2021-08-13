package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.ShopNewDTO;
import com.rainard.grindhouse.persistence.entity.ShopEntity;
import com.rainard.grindhouse.persistence.repository.ShopRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    private final String COFFEE_SHOP_TEST_NAME = "Test Coffee Shop";

    @InjectMocks
    private ShopServiceImpl shopService;

    @Mock
    private ShopRepository shopRepository;

    @Test
    void registerNewShop() {

        var newShopRequest = ShopNewDTO.builder()
            .name(COFFEE_SHOP_TEST_NAME)
            .build();

        assertNotNull(shopRepository);

        when(shopRepository.save(any(ShopEntity.class)))
            .thenReturn(ShopEntity.builder()
                .shopName(COFFEE_SHOP_TEST_NAME)
                .build());

        var newShopResponse = shopService.newShop(newShopRequest);

        assertEquals(HttpStatus.CREATED, newShopResponse.getStatusCode());

    }

}
