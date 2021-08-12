package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.ShopDTO;
import com.rainard.grindhouse.persistence.entity.ShopEntity;
import com.rainard.grindhouse.persistence.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public void newShop(final ShopDTO shopDTO) {

        var shopEntity = ShopEntity.builder()
            .shopName(shopDTO.getName())
            .build();

        shopRepository.save(shopEntity);
    }
}
