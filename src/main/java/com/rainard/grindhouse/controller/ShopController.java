package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dto.request.ShopDTO;
import com.rainard.grindhouse.service.ShopService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/shop/new")
    public ResponseEntity<Object> newShop(@Valid @RequestBody ShopDTO shopDTO) {
        shopService.newShop(shopDTO);
        return ResponseEntity.ok().build();
    }
}
