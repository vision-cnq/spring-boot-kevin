package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/13
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.kevin")
public class JSPApplication {

    public static void main(String[] args) {
        SpringApplication.run(JSPApplication.class,args);
    }
}
