package com.kevin.service;

import com.kevin.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/20
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserDaoImpl userDaoImpl;

    public void addUser(){
        this.userDaoImpl.saveUser();
    }
}
