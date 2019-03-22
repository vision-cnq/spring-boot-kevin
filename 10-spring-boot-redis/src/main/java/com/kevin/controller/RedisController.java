package com.kevin.controller;

import com.google.gson.Gson;
import com.kevin.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author kevin
 * @version 1.0
 * @description     在Controller层获取Redis中的数据
 * @createDate 2019/3/22
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    // redis        获取所有的keys，将对应的key-value转为json
    @RequestMapping("/keys")
    public String getKeys(){

        Map<String,String> map = new HashMap<>();

        // 获取到所有的key
        Set<String> keys = redisService.keys("*");
        for(String key : keys){
            // 根据key获取value
            String value = (String)this.redisService.get(key);
            map.put(key,value);
        }

        // 将map转为json
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

}
