package com.kevin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.mapper.UserMapper;
import com.kevin.entity.User;
import com.kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 判断用户是否存在
    public boolean isExist(String username) {
        User user = getName(username);
        return user!=null;
    }

    // 根据用户名获取用户信息
    public User getName(String username) {
        return this.userMapper.getName(username);
    }

    // 根据用户名和密码获取用户信息
    public User get(String username, String password) {
        return this.userMapper.get(username,password);
    }

}
