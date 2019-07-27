package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caonanqing
 * @version 1.0
 * @description         springboot+vue+element整合的后台代码
 * @createDate 2019/7/26
 */
@SpringBootApplication
@MapperScan("com.kevin.mapper")
public class SpringBootVueElementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootVueElementApplication.class,args);
    }
}
