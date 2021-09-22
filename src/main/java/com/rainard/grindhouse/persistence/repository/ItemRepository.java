package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ItemEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
}

