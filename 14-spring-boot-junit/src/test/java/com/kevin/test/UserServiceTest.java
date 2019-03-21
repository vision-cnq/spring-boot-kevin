package com.kevin.test;

import com.kevin.JunitApplication;
import com.kevin.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot测试类
 *
 *   @RunWith：启动器
 *      SpringJUnit4ClassRunner.class：让Junit与Spring环境进行整合
 *   @SpringBootTest(classes = {JunitApplication.class})
 *      含义：  1.当前类为SpringBoot的测试类
 *              2.加载SpringBoot启动类，启动SpringBoot
 *    Junit与Spring整合@Contextconfiguation("classpath:applicationContext.xml")
 *
 * @createDate 2019/3/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {JunitApplication.class})    // 可以设置多个启动器，逗号分隔
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void testAddUser(){
        userServiceImpl.addUser();
    }

}
