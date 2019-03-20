package com.kevin.controller;

import com.kevin.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合jsp
 * @createDate 2019/3/13
 */
@Controller
public class UserController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * 处理请求，产生数据
     * @return
     */
    @RequestMapping(value = "/showUser",method = RequestMethod.POST)
    public String showUser(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三",20));
        list.add(new User(2,"李四",21));
        list.add(new User(3,"王五",22));
        // 需要一个model对象
        model.addAttribute("list",list);
        // 跳转视图
        return "userList";
    }


}
