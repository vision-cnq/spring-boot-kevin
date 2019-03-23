package com.kevin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kevin
 * @version 1.0
 * @description     测试热部署
 * @createDate 2019/3/20
 */
@Controller
public class UsersController {

    @RequestMapping("/show")
    public String showPage(){
        System.out.println("showPage...init...");
        return "index";
    }

}
