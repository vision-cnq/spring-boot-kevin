package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caonanqing
 * @version 1.0
 * @description         整合Shiro
 * @createDate 2019/5/14
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.kevin.mapper"})       // 扫描Mybatis的mapper的接口
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }

}
