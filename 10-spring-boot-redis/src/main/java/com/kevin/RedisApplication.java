package com.kevin;

import com.kevin.utils.RedisTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author kevin
 * @version 1.0
 * @description     SpringBoot整合redis
 * @createDate 2019/3/13
 */
@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);

        //RedisTest.testSet();
    }
}
