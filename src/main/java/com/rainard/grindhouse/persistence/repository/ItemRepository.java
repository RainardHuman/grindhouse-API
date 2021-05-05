package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ItemEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
//    List<ItemEntity> findAllByFkOrderId(int id);
}