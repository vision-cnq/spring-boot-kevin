package com.kevin.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Listener方式一
 * <listener>
 *     <listener-class>com.kevin.web.listener.FirstListener</listener-class>
 * </listener>
 * @createDate 2019/3/13
 */
@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstListener...init...");
}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
