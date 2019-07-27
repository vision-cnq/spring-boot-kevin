package com.kevin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.entity.User;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/27
 */
public interface UserService extends IService<User> {

    User getName(String username);

    User get(String username, String password);
}
