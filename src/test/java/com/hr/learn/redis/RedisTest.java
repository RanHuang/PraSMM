package com.hr.learn.redis;

import com.context.RedisTestContext;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author nick
 * @date 19-5-29 星期三 22:42
 **/
public class RedisTest extends RedisTestContext {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testString() {
        String key = "hello";
        redisTemplate.opsForValue().set(key, "world");
        String value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
        Assert.assertEquals("world", value);
    }
}
