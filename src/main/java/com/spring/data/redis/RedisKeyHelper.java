package com.spring.data.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author kun.wang
 */
@Component
public class RedisKeyHelper {


    private static final Logger LOGGER = LoggerFactory.getLogger(RedisKeyHelper.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean deleteKey(String key) {
        return redisTemplate.delete(key);
    }

    public Long batchDeleteKeys(Collection<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param time
     * @param timeUnit
     * @return
     */
    public Boolean expire(String key, long time, TimeUnit timeUnit) {
        Assert.notNull(key, "non null key required");
        return redisTemplate.expire(key, time, timeUnit);
    }

    /**
     * 根据key获取redis的数据类型
     * @param key
     * @return
     */
    public String getKeyType(String key) {
        DataType dataType = redisTemplate.type(key);
        return dataType.code();
    }

    public Boolean exists(String key) {
        Assert.notNull(key, "non null key required");
        return redisTemplate.execute((RedisConnection connection) -> connection.exists(key.getBytes()));
    }

}
