package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author caonanqing
 * @version 1.0
 * @description     整合使用邮件，
 * @createDate 2019/10/10
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.kevin.*")
public class MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }
}
