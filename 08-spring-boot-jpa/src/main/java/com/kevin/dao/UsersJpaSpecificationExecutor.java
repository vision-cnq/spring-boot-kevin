package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kevin
 * @version 1.0
 * @description     JpaSpecificationExecutor的使用，提供多条件的支持，并且可以在查询中添加分页和排序
 * @createDate 2019/3/21
 */
public interface UsersJpaSpecificationExecutor extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
}
