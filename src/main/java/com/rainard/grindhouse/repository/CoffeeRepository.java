package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Integer> {
}