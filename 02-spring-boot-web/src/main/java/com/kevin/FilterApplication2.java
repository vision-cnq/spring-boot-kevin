package com.kevin;

import com.kevin.web.filter.SecondFilter;
import com.kevin.web.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Filter方式二
 * 通过方法完成Filer组件的注册
 * @createDate 2019/3/13
 */
@SpringBootApplication
public class FilterApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(FilterApplication2.class,args);
    }

    // 注册Servlet
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }

    // 注册Fliter
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
        //bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        bean.addUrlPatterns("/second");
        return bean;
    }
}
