package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ShopEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
    int countAllByCreatedBefore(Date created);
}