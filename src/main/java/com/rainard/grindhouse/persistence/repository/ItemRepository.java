package com.rainard.grindhouse.persistence.repository;
import com.rainard.grindhouse.persistence.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
    List<ItemEntity> findAllByFkOrderId(int id);
}