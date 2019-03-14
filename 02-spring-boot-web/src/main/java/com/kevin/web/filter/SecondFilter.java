package com.kevin.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Filter方式二
 * @createDate 2019/3/13
 */
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // 访问测试地址： http://localhost:8080/second
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
