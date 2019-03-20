package com.kevin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @version 1.0
 * @description     控制类
 * @createDate 2019/3/12
 */
@Controller
public class HelloWorld {

    // 访问地址： http://localhost:8080/hello
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> showHelloWorld(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","HelloWorld");
        return map;
    }
}
