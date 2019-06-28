package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author caonanqing
 * @version 1.0
 * @description     springboot+mybayis-plus+shiro，前后端分离，交互使用JSON数据
 * @createDate 2019/6/26
 */
@SpringBootApplication
@MapperScan("com.kevin.mapper")
@EnableTransactionManagement
public class ShiroJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroJsonApplication.class,args);
    }
}
