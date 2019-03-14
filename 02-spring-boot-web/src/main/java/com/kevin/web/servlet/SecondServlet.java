package com.kevin.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     Springboot整合Servlet方式二
 * @createDate 2019/3/13
 */
public class SecondServlet extends HttpServlet {

    // 访问测试地址： http://localhost:8080/second
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SecondServlet...");
    }
}
