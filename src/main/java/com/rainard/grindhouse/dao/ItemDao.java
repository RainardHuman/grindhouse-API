package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.table.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Integer> {
}