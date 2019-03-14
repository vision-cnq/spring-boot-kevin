package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot启动类
 * @createDate 2019/3/13
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.kevin.mapper"})       // 扫描Mybatis的mapper的接口
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
