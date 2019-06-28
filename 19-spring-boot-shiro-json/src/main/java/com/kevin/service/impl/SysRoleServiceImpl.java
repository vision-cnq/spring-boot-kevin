package com.kevin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.entity.SysUser;
import com.kevin.mapper.SysPermissionMapper;
import com.kevin.mapper.SysRoleMapper;
import com.kevin.entity.SysRole;
import com.kevin.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysRole> getAllRoles() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(new QueryWrapper<SysRole>().lambda().eq(SysRole::getStatus, 1));
        return sysRoles;
    }

    @Override
    public List<SysRole> listRole() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        return sysRoles;
    }

    /**
     * 添加角色
     */
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("unchecked")
    @Override
    public void addRole(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        SysRole sysRole = (SysRole)jsonObject.get("sysRole");
        String roleId = jsonObject.getString("roleId");
        List<Integer> permissions = (List<Integer>)jsonObject.get("permissions");
        sysRoleMapper.insert(sysRole);
        sysPermissionMapper.insertRolePermission(roleId,permissions);
    }

    /**
     * 修改角色
     */
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("unchecked")
    @Override
    public void updateRole(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String roleId = jsonObject.getString("roleId");
        List<Integer> newPerms = (List<Integer>) jsonObject.get("permissions");
        HashMap<String, Object> roleInfo = sysRoleMapper.getRoleAllInfo(Integer.parseInt(roleId));
        Set<Integer> oldPerms = (Set<Integer>) roleInfo.get("permissionIds");
        //修改角色名称
        dealRoleName(jsonObject, new JSONObject(roleInfo));
        //添加新权限
        saveNewPermission(roleId, newPerms, oldPerms);
        //移除旧的不再拥有的权限
        removeOldPermission(roleId, newPerms, oldPerms);
    }

    /**
     * 删除角色
     */
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings("unchecked")
    @Override
    public void deleteRole(String json) {
        SysRole sysRole = JSON.parseObject(json, SysRole.class);
        HashMap<String, Object> roleInfo = sysRoleMapper.getRoleAllInfo(sysRole.getRoleId());
        List<JSONObject> users = (List<JSONObject>) roleInfo.get("users");
        if (users != null && users.size() > 0) {
            throw new RuntimeException("删除角色失败");
        }
        sysRoleMapper.removeRole(String.valueOf(sysRole.getRoleId()));
        sysRoleMapper.removeRoleAllPermission(String.valueOf(sysRole.getRoleId()));

    }

    /**
     * 修改角色名称
     */
    private void dealRoleName(JSONObject paramJson, JSONObject roleInfo) {
        String roleName = paramJson.getString("roleName");
        String roleId = paramJson.getString("roleId");
        if (!roleName.equals(roleInfo.getString("roleName"))) {
            sysRoleMapper.updateRoleName(roleId,roleName);
        }
    }

    /**
     * 为角色添加新权限
     */
    private void saveNewPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
        List<Integer> waitInsert = new ArrayList<>();
        for (Integer newPerm : newPerms) {
            if (!oldPerms.contains(newPerm)) {
                waitInsert.add(newPerm);
            }
        }
        if (waitInsert.size() > 0) {
            sysPermissionMapper.insertRolePermission(roleId, waitInsert);
        }
    }

    /**
     * 删除角色 旧的 不再拥有的权限
     */
    private void removeOldPermission(String roleId, Collection<Integer> newPerms, Collection<Integer> oldPerms) {
        List<Integer> waitRemove = new ArrayList<>();
        for (Integer oldPerm : oldPerms) {
            if (!newPerms.contains(oldPerm)) {
                waitRemove.add(oldPerm);
            }
        }
        if (waitRemove.size() > 0) {
            sysPermissionMapper.removeOldPermission(roleId, waitRemove);
        }
    }
}
