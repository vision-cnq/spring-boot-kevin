package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Filter方式一
 * 通过注解扫描完成Filer组件的注册
 * @createDate 2019/3/13
 */
@SpringBootApplication
@ServletComponentScan
public class FilterApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(FilterApplication1.class,args);
    }
}
