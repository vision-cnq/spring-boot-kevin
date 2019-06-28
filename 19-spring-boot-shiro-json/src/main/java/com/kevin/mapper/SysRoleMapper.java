package com.kevin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询某角色的全部数据
     * 在删除和修改角色时调用
     */
    HashMap<String,Object> getRoleAllInfo(Integer roleId);

    /**
     * 修改角色名称
     */
    int updateRoleName(@Param("roleId") String roleId, @Param("roleName") String roleName);


    /**
     * 删除角色
     */
    int removeRole(@Param("roleId") String roleId);

    /**
     * 删除本角色全部权限
     */
    int removeRoleAllPermission(@Param("roleId") String roleId);
}
