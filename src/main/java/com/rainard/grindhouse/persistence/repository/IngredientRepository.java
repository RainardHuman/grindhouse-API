package com.rainard.grindhouse.persistence.repository;

import com.rainard.grindhouse.persistence.entity.IngredientEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity, Long> {
}

