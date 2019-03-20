package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     Repository接口的使用：方法名称命名查询的使用
 * @createDate 2019/3/20
 */
public interface UsersRepositoryByName extends Repository<Users,Integer> {

    // 方法命名规则：必须要遵循驼峰式命名规则。findBy(关键字)+属性名称(首字母要大写)+查询条件(首字母要大写)
    // 根据名字查询
    List<Users> findByName(String name);

    // 根据名字和年龄查询
    List<Users> findByNameAndAge(String name,Integer age);

    // 根据名字用通配符做查询
    List<Users> findByNameLike(String name);
}
