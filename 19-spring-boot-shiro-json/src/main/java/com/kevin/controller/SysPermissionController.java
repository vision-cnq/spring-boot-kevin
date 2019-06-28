package com.kevin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kevin.service.SysPermissionService;
import com.kevin.util.CommonUtil;
import com.kevin.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description     权限控制类
 * @createDate 2019/6/28
 */
@RestController
@RequestMapping("/permission")
public class SysPermissionController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 查询所有权限, 给角色分配权限时调用
     */
    @RequiresPermissions("role:list")
    @GetMapping("/listAllPermission")
    public Result listAllPermission() {
        logger.info("url: localhost:8080/user/listAllPermission");
        List<HashMap<String, Object>> list = sysPermissionService.listAllPermission();
        Result result = CommonUtil.successPage(list);
        return result;
    }

}
