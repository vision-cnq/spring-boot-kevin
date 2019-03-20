package com.kevin;

import com.kevin.web.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Servlet方式二
 * 通过方法完成Servlet组件的注册
 * @createDate 2019/3/13
 */
@SpringBootApplication
public class ServletApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication2.class,args);
    }

    // 通过方法完成Servlet组件的注册
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
}
