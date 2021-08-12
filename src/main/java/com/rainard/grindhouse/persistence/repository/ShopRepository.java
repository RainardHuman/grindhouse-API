package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ShopEntity;

import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}

