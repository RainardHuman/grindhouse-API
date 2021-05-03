package com.rainard.grindhouse.persistence.repository;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends CrudRepository<CoffeeEntity, Integer> {
}