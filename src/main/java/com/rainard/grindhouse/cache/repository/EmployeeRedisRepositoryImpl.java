package com.rainard.grindhouse.cache.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeRedisRepositoryImpl implements EmployeeRedisRepository {

    private final RedisTemplate<String, Long> redisTemplate;
    private HashOperations<String, String, Long> hashOperations;

    @Override
    public void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String sessionToken, Long id) {
        hashOperations.put("EMP", sessionToken, id);
    }

    @Override
    public Map<String, Long> findAll() {
        return hashOperations.entries("EMP");
    }

    @Override
    public Long findById(String sessionToken) {
        return hashOperations.get("EMP", sessionToken);
    }

    @Override
    public void delete(String sessionToken) {
        hashOperations.delete("EMP", sessionToken);
    }
}