package com.kevin.service.impl;

import com.kevin.dao.UsersJpaRepository;
import com.kevin.entity.Users;
import com.kevin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     UsersService接口实现类
 *
 * @createDate 2019/3/21
 */
@Repository
public class UserServiceImpl implements UsersService {

    @Autowired
    private UsersJpaRepository usersJpaRepository;

    @Override
    @Cacheable(value = "users")
    public List<Users> findUserAll() {
        return this.usersJpaRepository.findAll();
    }

    @Override
    @Cacheable(value = "users" )  // 对当前查询的对象做缓存处理
    public Users findUserById(Integer id) {
        return this.usersJpaRepository.findById(id).get();
    }

    @Override
    // 缓存的key，可以为空，按照SpEL表达式编写,如果不指定，则将方法内所有的参数组合起来
    // 就算是查询同个方法，如果key中参数对象的值不一样，在缓存中找不到该key，则还是会从数据库中取出
    @Cacheable(value = "users", key = "#pageable")
    public Page<Users> findUserByPage(Pageable pageable) {
        return this.usersJpaRepository.findAll(pageable);
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)        // 清除缓存中以users缓存策略缓存的对象
    public void saveUsers(Users users) {
        this.usersJpaRepository.save(users);
    }

}
