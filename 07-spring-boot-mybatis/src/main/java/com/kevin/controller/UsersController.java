package com.kevin.controller;

import com.kevin.entity.Users;
import com.kevin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     视图控制层
 * @createDate 2019/3/13
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /**
     *  用户添加    访问地址： http://localhost:8080/users/addUser
     * @param users
     */
    @RequestMapping("/addUser")
    public String addUser(Users users) {
        this.usersService.addUser(users);
        return "ok";
    }

    /**
     * 查询全部用户    访问地址： http://localhost:8080/users/findUserAll
     */
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<Users> list = this.usersService.findUserAll();
        model.addAttribute("list", list);
        return "showUsers";
    }

    /**
     * 根据用户id查询用户   访问地址： http://localhost:8080/users/findUserAll ，点更新用户会来到该方法根据id查询出来
     */
    @RequestMapping("/findUserById")
    public String findUserById(Integer id,Model model){
        Users user = this.usersService.findUserById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    /**
     * 更新用户   访问地址： http://localhost:8080/users/findUserAll ，点更新用户后修改点确定就会来到该方法修改
     */
    @RequestMapping("/editUser")
    public String editUser(Users users){
        this.usersService.updateUser(users);
        return "ok";
    }

    /**
     * 删除用户   访问地址： http://localhost:8080/users/findUserAll ，点删除用户会来到该方法进行删除
     */
    @RequestMapping("/delUser")
    public String delUser(Integer id){
        this.usersService.deleteUserById(id);
        return "redirect:/users/findUserAll";
    }

}
