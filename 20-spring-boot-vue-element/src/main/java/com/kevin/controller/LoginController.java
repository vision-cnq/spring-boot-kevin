package com.kevin.controller;

import com.kevin.entity.User;
import com.kevin.service.UserService;
import com.kevin.utils.Result;
import com.kevin.utils.enums.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    public Result login(@RequestBody User user, HttpSession session) {
        Result result;
        User userInfo = userService.get(user.getUsername(), user.getPassword());
        if(userInfo != null) {
            result = Result.ok();
            session.setAttribute("user", userInfo);        // 保存用户信息到session中
        } else {
            ResponseCodeEnum codeEnum = ResponseCodeEnum.INCORRECT_ACCOUNT_OR_PASSWORD;
            result = Result.build(codeEnum.getCode(), codeEnum.getMsg());
        }
        logger.info(result.getMsg());   // 保存日志
        return result;
    }
}
