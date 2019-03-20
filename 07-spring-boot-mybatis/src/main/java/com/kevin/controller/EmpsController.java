package com.kevin.controller;

import com.google.gson.Gson;
import com.kevin.entity.Emps;
import com.kevin.service.EmpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     用注解方式获取数据
 * @createDate 2019/3/20
 */
@RestController
@RequestMapping("/emps")
public class EmpsController {

    @Autowired
    private EmpsService empsService;

    @RequestMapping("/select")
    public String selectEmps(){

        List<Emps> emps = empsService.selectEmps();

        // 将list的对象解析成json展示到页面
        Gson gson = new Gson();
        String json = gson.toJson(emps);
        return json;
    }
}
