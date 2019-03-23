package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin
 * @version 1.0
 * @description     SpringBoot的异常处理
 *
 *      SpringBoot默认的处理异常的机制：SpringBoot默认的已经提供一套处理异常的机制。
 *      一旦程序中出现了异常SpringBoot会像/error的url发送请求，在SpringBoot中提供了一个
 *      叫BasicExceptionController来处理/error请求，然后跳转到默认显示异常来展示异常信息。
 * @createDate 2019/3/22
 */
@SpringBootApplication
public class ExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class,args);
    }
}
