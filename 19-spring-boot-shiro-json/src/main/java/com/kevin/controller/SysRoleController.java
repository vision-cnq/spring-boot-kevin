package com.kevin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.SysRole;
import com.kevin.service.SysRoleService;
import com.kevin.util.CommonUtil;
import com.kevin.util.Result;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description     角色控制类
 * @createDate 2019/6/28
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 获取启用的角色
     * @return
     */
    @RequiresPermissions(value = {"user:add", "user:update"}, logical = Logical.OR)
    @GetMapping("/getAllRoles")
    public Result getAllRoles() {
        logger.info("url: localhost:8080/role/getAllRoles");
        List<SysRole> allRoles = sysRoleService.getAllRoles();
        Result result = CommonUtil.successPage(allRoles);
        return result;
    }

    /**
     * 获取角色列表
     * @return
     */
    @RequiresPermissions("role:list")
    @GetMapping("/listRole")
    public Result listRole(){
        logger.info("url: localhost:8080/role/listRole");
        List<SysRole> sysRoles = sysRoleService.listRole();
        Result result = Result.ok();
        result.addInfo("roles",sysRoles);
        return result;
    }


    /**
     * 新增角色
     */
    @RequiresPermissions("role:add")
    @PostMapping("/addRole")
    public Result addRole(@RequestBody String json) {
        logger.info("url: localhost:8080/user/addRole" + " , json: " + json);
        CommonUtil.hasAllRequired(json, "roleName,permissions");
        sysRoleService.addRole(json);
        return Result.ok();
    }

    /**
     * 修改角色
     */
    @RequiresPermissions("role:update")
    @PostMapping("/updateRole")
    public Result updateRole(@RequestBody String json) {
        logger.info("url: localhost:8080/user/updateRole" + " ,json: " + json);
        CommonUtil.hasAllRequired(json, "roleId,roleName,permissions");
        sysRoleService.updateRole(json);
        return Result.ok();
    }

    /**
     * 删除角色
     */
    @RequiresPermissions("role:delete")
    @PostMapping("/deleteRole")
    public Result deleteRole(@RequestBody String json ) {
        logger.info("url: localhost:8080/user/deleteRole" + " ,json: " + json);
        CommonUtil.hasAllRequired(json, "roleId");
        sysRoleService.deleteRole(json);
        return Result.ok();
    }
}
