package com.rainard.grindhouse.dao;
import com.rainard.grindhouse.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Integer> {
}