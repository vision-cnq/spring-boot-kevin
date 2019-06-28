package com.kevin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.entity.SysRole;

import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 查询用户所拥有的角色
     * @return
     */
    List<SysRole> getAllRoles();

    /**
     * 角色列表
     * @return
     */
    List<SysRole> listRole();

    /**
     * 添加角色
     */
    void addRole(String json);

    /**
     * 修改角色
     */
    void updateRole(String json);

    /**
     * 删除角色
     */
    void deleteRole(String json);

}
