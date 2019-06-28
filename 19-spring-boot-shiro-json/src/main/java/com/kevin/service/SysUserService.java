package com.kevin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.entity.SysUser;
import com.kevin.util.Result;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 用户列表
     * @return
     */
    Result listUser();

    /**
     * 添加用户
     * @return
     */
    void addUser(String json);

    /**
     * 修改用户
     */
    void updateUser(String json);


}
