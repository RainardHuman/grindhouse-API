package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.ShopNewDTO;
import com.rainard.grindhouse.persistence.entity.ShopEntity;
import com.rainard.grindhouse.persistence.repository.ShopRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ResponseEntity<Object> newShop(final ShopNewDTO shopNewDTO) {

        var shopEntity = ShopEntity.builder()
            .shopName(shopNewDTO.getName())
            .build();

        shopRepository.save(shopEntity);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
