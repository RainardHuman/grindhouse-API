package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.ShopNewDTO;

import org.springframework.http.ResponseEntity;

public interface ShopService {
    ResponseEntity<Object> newShop(final ShopNewDTO shopNewDTO);
}
