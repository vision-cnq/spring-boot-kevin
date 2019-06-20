package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author caonanqing
 * @version 1.0
 * @description         设置图片验证码
 * @createDate 2019/6/17
 */
@SpringBootApplication
public class KaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaptchaApplication.class,args);
    }
}
