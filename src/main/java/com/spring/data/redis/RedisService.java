package com.spring.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author kun.wang
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;






    public Set<String> scan(String pattern, int count) {

        return redisTemplate.execute((RedisConnection connection) -> {
            Set<String> keyResult = new HashSet<>();
            ScanOptions options = new ScanOptions.ScanOptionsBuilder().match(pattern).count(count).build();
            /**
             * 此方法会一直调用，直到返回的cursorId为0为止
             */
            Cursor<byte[]> cursor = connection.scan(options);
            while (cursor.hasNext()) {
                String key = new String(cursor.next());
                keyResult.add(key);
            }
            return keyResult;
        });
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
