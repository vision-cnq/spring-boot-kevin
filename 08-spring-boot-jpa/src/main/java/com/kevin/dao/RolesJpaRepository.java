package com.kevin.dao;

import com.kevin.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kevin
 * @version 1.0
 * @description     操作Roles表
 * @createDate 2019/3/21
 */
public interface RolesJpaRepository extends JpaRepository<Roles,Integer> {

}
