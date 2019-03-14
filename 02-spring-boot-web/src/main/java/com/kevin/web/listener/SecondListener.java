package com.kevin.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Listener方式二
 * @createDate 2019/3/13
 */
public class SecondListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener...init...");
}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
