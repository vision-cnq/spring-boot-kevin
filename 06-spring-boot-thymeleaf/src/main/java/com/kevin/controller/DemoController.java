package com.kevin.controller;

import com.kevin.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合Thymeleaf的案例
 * @createDate 2019/3/14
 */
@Controller
public class DemoController {

    /**
     * Thymeleaf中的字符串案例
     * 访问地址     http://localhost:8080/show
     * @param model
     * @return
     */
    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg","Thymeleaf第一个案例");
        model.addAttribute("key", new Date());  // 测试日期
        return "string";
    }

    /**
     * Thymeleaf中的条件判断
     * 访问地址     http://localhost:8080/show2
     * @param model
     * @return
     */
    @RequestMapping("/show2")
    public String showInfo2(Model model){
        model.addAttribute("sex", "女");
        model.addAttribute("id","1");
        return "ifAndSwitch";
    }

    /**
     * Thymeleaf中遍历List
     * 访问地址     http://localhost:8080/show3
     * @param model
     * @return
     */
    @RequestMapping("/show3")
    public String showInfo3(Model model){
        List<Users> list = new ArrayList<>();
        list.add(new Users(1,"张三",20));
        list.add(new Users(2,"李四",22));
        list.add(new Users(3,"王五",24));
        model.addAttribute("list", list);
        return "listEach";
    }

    /**
     * Thymeleaf中遍历Map
     * 访问地址     http://localhost:8080/show4
     * @param model
     * @return
     */
    @RequestMapping("/show4")
    public String showInfo4(Model model){
        Map<String, Users> map = new HashMap<>();
        map.put("u1", new Users(1,"张三",20));
        map.put("u2", new Users(2,"李四",22));
        map.put("u3", new Users(3,"王五",24));
        model.addAttribute("map", map);
        return "mapEach";
    }

    /**
     * Thymeleaf中获取作用域中的对象
     * 访问地址     http://localhost:8080/show5
     * @param model
     * @return
     */
    @RequestMapping("/show5")
    public String showInfo5(HttpServletRequest request, Model model){
        request.setAttribute("req", "HttpServletRequest");
        request.getSession().setAttribute("sess", "HttpSession");
        request.getSession().getServletContext().setAttribute("app", "Application");
        return "request";
    }

    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page, Integer id, String name){
        System.out.println(id+"--"+name);
        return page;
    }
}
