package com.kevin.service.impl;

import com.kevin.entity.User;
import com.kevin.mapper.UserMapper;
import com.kevin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        // 查询用户是否存在
        User bean = userMapper.findByName(name);
        if (bean != null) {
            // 查询用户信息、角色、权限
            bean = userMapper.findById(bean.getId());
        }
        return bean;
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
