package com.kevin.mapper;

import com.kevin.entity.Users;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     使用xml形式获取数据，数据持久层
 * @createDate 2019/3/13
 */
public interface UsersMapper {

    void insertUser(Users users);

    List<Users> selectUsersAll();

    Users selectUsersById(Integer id);

    void updateUser(Users users);

    void deleteUserById(Integer id);
}
