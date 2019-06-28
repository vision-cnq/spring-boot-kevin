package com.kevin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.SysRole;
import com.kevin.service.SysRoleService;
import com.kevin.service.SysUserService;
import com.kevin.util.CommonUtil;
import com.kevin.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description     用户控制类
 * @createDate 2019/6/27
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询用户列表
     */
    @RequiresPermissions("user:list")
    @GetMapping("/list")
    public Result listUser() {
        logger.info("url: localhost:8083/user/list");
        Result result = sysUserService.listUser();
        logger.info(JSON.toJSONString(result));
        return result;
    }

    /**
     * 新增用户
     * @param json
     * @return
     */
    @RequiresPermissions("user:add")
    @PostMapping("/addUser")
    public Result addUser(@RequestBody String json) {
        logger.info("url: localhost:8080/user/addUser" + " ,json: " + json);
        CommonUtil.hasAllRequired(json,"username, password, roleId");    // 非空判断
        sysUserService.addUser(json);
        return Result.ok();
    }

    /**
     * 更新用户
     * @param json
     * @return
     */
    @RequiresPermissions("user:update")
    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody String json) {
        logger.info("url: localhost:8080/user/updateUser" + "json: " + json);
        sysUserService.updateUser(json);
        return Result.ok();
    }

}
