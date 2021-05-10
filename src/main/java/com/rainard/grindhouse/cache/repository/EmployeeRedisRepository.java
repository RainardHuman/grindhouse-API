package com.rainard.grindhouse.cache.repository;

import java.util.Map;

public interface EmployeeRedisRepository {

    void save(String sessionToken, Long id);

    Map<String, Long> findAll();

    Long findById(String sessionToken);

    void delete(String sessionToken);

    void init();

}
