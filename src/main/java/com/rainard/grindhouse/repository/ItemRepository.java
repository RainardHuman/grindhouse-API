package com.rainard.grindhouse.repository;
import com.rainard.grindhouse.model.table.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findAllByFkOrderId(int id);
}