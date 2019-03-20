package com.kevin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kevin
 * @version 1.0
 * @description     访问静态资源
 * @createDate 2019/3/13
 */
@Controller
public class StaticController {

    // 访问static中的index.html的地址：localost:8080/index
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}

