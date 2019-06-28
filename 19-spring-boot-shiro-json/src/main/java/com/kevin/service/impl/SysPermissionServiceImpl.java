package com.kevin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.entity.SysUser;
import com.kevin.mapper.SysPermissionMapper;
import com.kevin.entity.SysPermission;
import com.kevin.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper,SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<HashMap<String,Object>> listAllPermission() {

        List<HashMap<String,Object>> permissions = sysPermissionMapper.listAllPermission();
        return permissions;
    }

    @Override
    public HashMap<String,Object> getUserPermission(String name) {
        HashMap<String, Object> permission = sysPermissionMapper.getUserPermission(name);
        JSONObject json = new JSONObject(permission);
        // 如果是管理员角色则，id为1
        int adminRoleId = 1;
        //如果是管理员
        String roleIdKey = "roleId";
        if(adminRoleId == json.getIntValue(roleIdKey)){
            Set<String> menuList = new HashSet();
            Set<String> permissionList = new HashSet();
            // 查询所有菜单，所有权限
            List<SysPermission> permissions = sysPermissionMapper.selectList(null);
            for (SysPermission sysPermission : permissions) {
                menuList.add(sysPermission.getMenuCode());
                permissionList.add(sysPermission.getPermissionUrl());
            }
            permission.put("menuList",menuList);
            permission.put("permissionList",permissionList);
        }
        return permission;
    }
}
