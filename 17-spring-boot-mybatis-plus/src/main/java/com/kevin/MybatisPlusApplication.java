package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/16
 */
@EnableTransactionManagement
@MapperScan("com.kevin.mapper")
@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
        System.out.println("http://localhost:8083/sysUser/test");
    }


}
