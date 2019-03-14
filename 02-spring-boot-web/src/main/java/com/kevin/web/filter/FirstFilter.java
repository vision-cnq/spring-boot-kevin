package com.kevin.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Filter方式一
 * <filter>
 *     <filter-name>FirstFilter</filter-name>
 *     <filter-calss>com.kevin.web.filter.FirstFilter</filter-calss>
 * </filter>
 * <filter-mapping>
 *      <filter-name>FirstFilter</filter-name>
 *      <url-pattern>/first</url-pattern>
 * </filter-mapping>
 * @createDate 2019/3/13
 */

//@WebFilter(filterName = "FirstFilter", urlPatterns = {"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 访问测试地址： http://localhost:8080/first
    @Override
    public void doFilter(ServletRequest s1, ServletResponse s2, FilterChain s3) throws IOException, ServletException {
        System.out.println("进入Filter");
        s3.doFilter(s1,s2);
        System.out.println("离开Filter");
    }

    @Override
    public void destroy() {

    }
}
