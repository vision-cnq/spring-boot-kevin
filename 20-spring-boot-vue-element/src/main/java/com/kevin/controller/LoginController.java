package com.kevin.controller;

import com.kevin.entity.User;
import com.kevin.service.UserService;
import com.kevin.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/27
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        User user1 = userService.get(user.getUsername(), user.getPassword());
        if(user1 != null) {
            Result result = Result.ok();
            logger.info(result.getMsg());
            return result;
        } else {
            Result result = Result.build(400, "账号或密码错误! ");
            logger.info(result.getMsg());
            return result;
        }

    }
}
