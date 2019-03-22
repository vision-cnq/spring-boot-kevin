package com.kevin.service;

import com.kevin.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/21
 */
public interface UsersService {

    List<Users> findUserAll();

    Users findUserById(Integer id);

    Page<Users> findUserByPage(Pageable pageable);

    void saveUsers(Users users);

}
