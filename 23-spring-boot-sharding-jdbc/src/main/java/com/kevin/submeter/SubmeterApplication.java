package com.kevin.submeter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caonanqing
 * @version 1.0
 * @description     分表测试案例
 * @createDate 2020/1/13
 */
@MapperScan("com.kevin.submeter.mapper")
@SpringBootApplication
public class SubmeterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubmeterApplication.class,args);
    }

}
