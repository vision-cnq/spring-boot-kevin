package com.kevin.submeter.controller;

import cn.hutool.core.util.RandomUtil;
import com.google.common.collect.Lists;
import com.kevin.submeter.entity.User;
import com.kevin.submeter.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2020/1/13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param name
     * @param sex
     * @param age
     * @return
     */
    @RequestMapping("/sale")
    public String save(@Param("name") String name, @Param("sex") String sex, @Param("age") Integer age){
        boolean save = userService.save(new User(name, sex, age));
        if(save) {
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping("/list")
    public Object listUser() {
        List<User> list = userService.list();
        return list;
    }

    /**
     * 批量新增用户
     * @return
     */
    @RequestMapping("/saveAll")
    public String saveUser() {

        List<User> userList = Lists.newArrayList();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 20; j++) {
                userList.add(new User(RandomUtil.randomString(5), "男", j));
            }
        }

        boolean batch = userService.saveBatch(userList);
        if(batch) {
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

}
