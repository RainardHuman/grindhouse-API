package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.table.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeDao extends CrudRepository<Coffee, Integer> {
}