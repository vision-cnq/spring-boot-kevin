package com.kevin.controller;

import com.kevin.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/14
 */
@Controller
public class UsersController {

    /**
     * 该页面跳到转add.html页面上进行操作
     * 访问地址 http://localhost:8080/addUser
     * @return
     */
    @RequestMapping("/addUser")
    public String showPage(){
        return "add";
    }

    /**
     * 完成用户添加
     * 该方法由add.html中的表单提交跳转到此处
     * @param users
     * @return
     */
    @RequestMapping("/save")
    public String saveUser(Users users){
        System.out.println(users);
        return "ok";
    }
}
