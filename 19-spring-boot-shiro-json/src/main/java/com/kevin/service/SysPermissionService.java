package com.kevin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.entity.SysPermission;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 查询所有的权限，为角色分配时调用
     * @return
     */
    List<HashMap<String,Object>> listAllPermission();

    /**
     * 查询某用户的 角色  菜单列表   权限列表
     */
    HashMap<String,Object> getUserPermission(String name);
}
