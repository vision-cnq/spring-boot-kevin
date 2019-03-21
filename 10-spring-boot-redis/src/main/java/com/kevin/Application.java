package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/13
 */
@SpringBootApplication
@EnableCaching      // 开启缓存
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
