package com.kevin;

import com.kevin.web.listener.SecondListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Listener方式二
 * 通过方法完成Listener组件的注册
 * @createDate 2019/3/13
 */
@SpringBootApplication
public class ListenerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication2.class,args);
    }

    // 注册Listener
    @Bean
    public ServletListenerRegistrationBean<SecondListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<SecondListener> bean =
                new ServletListenerRegistrationBean<SecondListener>(new SecondListener());
        return bean;
    }
}
