package com.kevin.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Servlet方式一
 * <servlet>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <servlet-class>com.kevin.web.servlet.FirstServlet</servlet-class>
 * </servlet>
 *
 * @WebServlet注解对应这个配置，上面那个配置不需要，应该在该类下配置的
 * <servlet-mapping>
 *     <servlet-name>FirstServlet</servlet-name>
 *     <url-pattern>/first</url-pattern>
 * </servlet-mapping>
 *
 * @createDate 2019/3/13
 */
@WebServlet(name="FirstServlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    // 访问测试地址： http://localhost:8080/first
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FirstServlet...");
    }

}
