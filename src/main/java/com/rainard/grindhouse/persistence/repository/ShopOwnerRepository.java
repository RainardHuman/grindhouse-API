package com.rainard.grindhouse.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOwnerRepository extends CrudRepository<ShopOwnerRepository, Long> {
}

