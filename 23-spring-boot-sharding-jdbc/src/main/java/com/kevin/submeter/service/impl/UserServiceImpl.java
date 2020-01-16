package com.kevin.submeter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.submeter.entity.User;
import com.kevin.submeter.mapper.UserMapper;
import com.kevin.submeter.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2020/1/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
