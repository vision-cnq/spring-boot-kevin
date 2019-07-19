package com.kevin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author caonanqing
 * @version 1.0
 * @description     springboot+mybayis-plus+shiro，前后端分离，交互使用JSON数据
 * @createDate 2019/6/26
 */
@SpringBootApplication
@MapperScan("com.kevin.mapper")
@EnableTransactionManagement
public class ShiroJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroJsonApplication.class,args);
    }


    /**
     *
     *  Accept: application/json, text/plain,
        Accept-Encoding:gzip,deflate,br
        Accept-Language:zh-CN,zh;q=0.9,en;q=0.8
        Cache-Control:no-cache
        Connection:keep-alive
        Content-Length:0
        Cookie:Idea-9c561e02=a212dc68-eb5d-47fc-aaa2-be94090522df;sidebarStatus=0;JSESSIONID=179CEF7EDA0AF45DDBAE8E076F8C267E;hasLogin=1
        Host:localhost:9520
        Origin:http://localhost:9520
        Pragma:no-cache
        Referer:http://localhost:9520/
        User-Agent:Mozilla/5.0(
        Windows NT 10.0;Win64;x64)AppleWebKit/537.36(KHTML,
        like Gecko)Chrome/74.0.3729.131Safari/537.36
     */
}
