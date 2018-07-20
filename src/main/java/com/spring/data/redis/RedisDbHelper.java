package com.spring.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author kun.wang
 */
@Component
public class RedisDbHelper {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void flushAllDb() {
        redisTemplate.execute((RedisConnection connection) -> {
            connection.flushAll();
            return null;
        });
    }

    public void flushCurrentDb() {
        redisTemplate.execute((RedisConnection connection) -> {
            connection.flushDb();
            return null;
        });
    }
}
