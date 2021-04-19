package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}