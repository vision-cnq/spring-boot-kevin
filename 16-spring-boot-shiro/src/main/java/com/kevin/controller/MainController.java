package com.kevin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caonanqing
 * @version 1.0
 * @description     用户登录，登出，错误页面跳转控制器
 * @createDate 2019/5/14
 */
@Controller
public class MainController {

    /**
     * 主页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/main")
    public String index(HttpServletRequest request, HttpServletResponse response){
        System.out.println("==========MainController.index()==========");

        response.setHeader("root", request.getContextPath());
        return "index";
    }

    /**
     * 登录界面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, HttpServletResponse response){
        System.out.println("==========MainController.toLogin()==========");

        response.setHeader("root", request.getContextPath());
        return "login";
    }

    /**
     *      登录判断界面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("==========MainController.login()==========");

        response.setHeader("root", request.getContextPath());
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 3.执行登录方法
        try{
            subject.login(token);
            return "redirect:/main";    // 认证成功，来到主页
        } catch (UnknownAccountException e){
            e.printStackTrace();
            request.setAttribute("msg","用户名不存在！");
        } catch (IncorrectCredentialsException e){
            request.setAttribute("msg","密码错误！");
        }

        return "login";     // 失败，返回登录界面
    }

    /**
     * 退出登录，返回主页
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        System.out.println("==========MainController.logout()==========");

        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "redirect:/main";
    }

    /**
     * 没有权限
     * @return
     */
    @RequestMapping("/error/unAuth")
    public String unAuth(){
        System.out.println("==========MainController.unAuth()==========");

        return "/error/unAuth";
    }
}