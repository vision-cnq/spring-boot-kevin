package com.kevin.utils;

import com.kevin.service.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author kevin
 * @version 1.0
 * @description     在非Controller层下使用@Autowired注入service
 * @createDate 2019/3/22
 */
@Component      // 该注解手动将该类实例到SpringIOC容器中
public class RedisTest {

    public static RedisTest redisTest;

    @Autowired      // 注入RedisService
    private RedisService redisService;

    @PostConstruct      // 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，类似于Serclet的inti()方法
    public void init(){
        redisTest = this;
        redisTest.redisService = this.redisService;
    }

    // 插入数据
    public static void testSet() {
        // 将key-value键值对数据插入redis，设置生命周期，5分钟
        redisTest.redisService.set("tomcat","广州",60*5);
        redisTest.redisService.set("netty","广州",60*5);
    }

}
