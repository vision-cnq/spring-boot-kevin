package com.kevin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 查询用户的角色 菜单 权限
     */
    HashMap<String,Object> getUserPermission(String name);

    /**
     * 批量插入角色的权限
     *
     * @param roleId      角色ID
     * @param permissions 权限
     */
    int insertRolePermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);

    /**
     * 将角色曾经拥有而修改为不再拥有的权限 delete_status改为'2'
     */
    int removeOldPermission(@Param("roleId") String roleId, @Param("permissions") List<Integer> permissions);

    /**
     * 查询所有权限, 给角色分配权限时调用
     */
    List<HashMap<String,Object>> listAllPermission();
}
