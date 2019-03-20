package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kevin
 * @version 1.0
 * @description         JpaRepository接口的使用
 *      参数一 T ：当前需要映射的实体类
 *      参数二 ID ：当前映射的实体类中的OID的类型
 * @createDate 2019/3/20
 */
public interface UsersRepository extends JpaRepository<Users,Integer> {



}
