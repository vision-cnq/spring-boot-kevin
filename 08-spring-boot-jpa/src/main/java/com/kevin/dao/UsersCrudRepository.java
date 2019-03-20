package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kevin
 * @version 1.0
 * @description     CrudRepository接口的使用：主要是完成一些增删改查的操作。
 *      CrudRepository接口继承了Repository接口
 * @createDate 2019/3/20
 */
public interface UsersCrudRepository extends CrudRepository<Users,Integer> {

}
