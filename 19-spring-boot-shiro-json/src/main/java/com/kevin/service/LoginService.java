package com.kevin.service;

import com.kevin.entity.SysUser;
import com.kevin.util.Result;

/**
 * @author caonanqing
 * @version 1.0
 * @description     登录专用Service
 * @createDate 2019/6/27
 */
public interface LoginService {

    /**
     * 登录表单提交
     */
    void authLogin(String json);

    /**
     * 根据用户名查询对应的用户
     * @param name      用户名
     */
    SysUser getUser(String name);

    /**
     * 查询当前登录用户的权限等信息
     */
    Result getInfo();

}
