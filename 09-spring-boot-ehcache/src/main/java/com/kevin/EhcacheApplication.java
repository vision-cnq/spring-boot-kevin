package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin
 * @version 1.0
 * @description     SpringBoot整合Ehcache缓存
 * @createDate 2019/3/21
 */
@SpringBootApplication
public class EhcacheApplication {

    public static void main(String[] args) {

        SpringApplication.run(EhcacheApplication.class,args);
    }
}
