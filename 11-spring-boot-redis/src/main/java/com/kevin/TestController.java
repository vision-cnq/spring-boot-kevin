package com.kevin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author kevin
 * @version 1.0
 * @description     测试redis
 * @createDate 2019/3/13
 */
public class TestController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void test(){

    }
}
