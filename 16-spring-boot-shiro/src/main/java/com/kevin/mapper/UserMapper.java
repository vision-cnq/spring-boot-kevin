package com.kevin.mapper;

import com.kevin.entity.User;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/14
 */
public interface UserMapper {

    /**
     * 查询用户信息
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 查询用户信息，角色，权限
     * @param id
     * @return
     */
    User findById(String id);
}
