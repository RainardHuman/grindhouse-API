package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ShopEmployeeEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOwnerRepository extends CrudRepository<ShopEmployeeEntity, Long> {
}

