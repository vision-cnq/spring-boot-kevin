package com.kevin.dao;

import org.springframework.stereotype.Repository;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/20
 */
@Repository
public class UserDaoImpl {

    public void saveUser(){
        System.out.println("insert into users...");
    }
}
