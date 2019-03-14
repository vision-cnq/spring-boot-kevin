package com.kevin.service;

import com.kevin.entity.Users;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     业务层
 * @createDate 2019/3/13
 */
public interface UsersService {

    void addUser(Users users);

    List<Users> findUserAll();

    Users findUserById(Integer id);

    void updateUser(Users users);

    void deleteUserById(Integer id);
}
