package com.kevin.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/20
 */
@Service
public class UsersService {

    public void addUsers(){
        System.out.println("ServiceExecute..."+new Date());
    }
}
