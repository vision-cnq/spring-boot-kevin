package com.kevin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.mapper.SysUserMapper;
import com.kevin.entity.SysUser;
import com.kevin.service.SysUserService;
import com.kevin.util.CommonUtil;
import com.kevin.util.MD5Utils;
import com.kevin.util.Result;
import com.kevin.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Result listUser() {

        Integer count = sysUserMapper.selectCount(new QueryWrapper<SysUser>().lambda().eq(SysUser::getAccountStatus, 1));
        // 获取数据
        List<HashMap<String, Object>> list = sysUserMapper.listUser(0, 10);
        Result result = CommonUtil.successPage(list, count);
        return result;
    }

    @Override
    public void addUser(String json) {
        SysUser sysUser = JSON.parseObject(json, SysUser.class);
        Integer count = sysUserMapper.selectCount(new QueryWrapper<SysUser>().lambda().eq(SysUser::getName, "").eq(SysUser::getAccountStatus, 1));
        if (count > 0) {
            throw new RuntimeException("用户已存在");
        }
        String password = MD5Utils.encrypt(sysUser.getName(), sysUser.getPassword());
        sysUser.setPassword(password);
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void updateUser(String json) {
        SysUser sysUser = JSON.parseObject(json, SysUser.class);
        sysUserMapper.updateById(sysUser);
    }
}
