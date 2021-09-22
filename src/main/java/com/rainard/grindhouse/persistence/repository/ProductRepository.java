package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.ProductEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}

