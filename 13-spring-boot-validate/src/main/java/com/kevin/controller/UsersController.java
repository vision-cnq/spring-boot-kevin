package com.kevin.controller;

import com.kevin.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot整合hibernate Validate效验的控制层
 * @createDate 2019/3/14
 */
@Controller
public class UsersController {

    /**
     * 该页面跳到转add.html页面上进行操作
     * 访问地址 http://localhost:8080/addUser
     * 方式一：
     * 解决Exception processing template "add": Error during execution of processor 'org.thymeleaf.spring5.processor.SpringErrorsTagProcessor'
     * 异常的方式。可以在跳转页面的方法中注入一个Users对象。例如：public String showPage(Users users)
     * 注意：由于springmvc会将对象放入Model中传递，key的名称会使用该对象的驼峰式命名规则作为key，
     * 参数的变量名需要与对象的名称相同，将首字母小写。
     *
     * 方式二：
     * 如果不想名称是默认的驼峰式的命名，想使用自定义的命名方式
     * 可以使用@ModelAttribute，比如我想命名成u，例如：public String showPage(@ModelAttribute("u") Users users)
     *
     * @return
     */
    @RequestMapping("/addUser")
    public String showPage(Users users){
        return "add";
    }

    /**
     * 完成用户添加
     * 该方法由add.html中的表单提交跳转到此处
     * @param users
     * @return
     */
    /*@RequestMapping("/save")
    public String saveUser(Users users){
        System.out.println(users);
        return "ok";
    }*/

    /**
     * 完成用户添加
     * 该方法由add.html中的表单提交跳转到此处
     * @Valid 注解表示开启对Users对象的数据效验
     * BindingResult: 封装了效验的结果
     *
     * 页面校验要是用命名要是想自定义的需要加上@ModelAttribute
     * public String saveUser(@ModelAttribute("u") @Valid Users users, BindingResult result)
     * @param users
     * @return
     */
    @RequestMapping("/save")
    public String saveUser(@Valid Users users, BindingResult result){

        // 效验失败
        if(result.hasErrors()) {
            return "add";
        }
        System.out.println(users);
        return "ok";
    }
}
