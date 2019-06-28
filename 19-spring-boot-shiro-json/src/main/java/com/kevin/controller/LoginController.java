package com.kevin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kevin.service.LoginService;
import com.kevin.util.CommonUtil;
import com.kevin.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     登录控制层
 * @createDate 2019/6/27
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private LoginService loginService;

    /**
     * 登录用户
     * @param json
     * @return
     */
    @PostMapping("/auth")
    public Result authLogin(@RequestBody String json){

        logger.info("url: localhost:8083/login/auth" + " ,json: "+json);
        CommonUtil.hasAllRequired(json,"username,password");    // 非空判断
        Result result = Result.fail();
        try {
            loginService.authLogin(json);
            result = Result.ok();
            result.addInfo("result","success");
            logger.info("登录成功" + JSON.toJSONString(result));
        }catch (UnknownAccountException e){
            result.addInfo("result","fail");
            logger.info("用户不存在");
        } catch (IncorrectCredentialsException e){
            result.addInfo("result","fail");
            logger.info("密码错误");
        }
        return result;
    }

    /**
     * 查询当前登录用户的信息
     * @return
     */
    @PostMapping("/getInfo")
    public Result getInfo(){
        logger.info("url: localhost:8083/login/getInfo");
        Result result = loginService.getInfo();
        return result;
    }

    /**
     * 退出登录，返回主页
     * @return
     */
    @RequestMapping("/logout")
    public Result logout(){
        logger.info("url: localhost:8083/login/logout");
        Result result;
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
            result = Result.ok();
            result.setMsg("退出登录");
        } else{
            result = Result.fail();
            result.setMsg("未登录");
        }
        return result;
    }

}
