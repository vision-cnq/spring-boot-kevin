package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.dao.UsersJpaRepository;
import com.kevin.entity.Roles;
import com.kevin.entity.Users;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kevin
 * @version 1.0
 * @description     测试一对多关联
 * @createDate 2019/3/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class OneToManyTest {

    @Autowired
    private UsersJpaRepository usersJpaRepository;

    // 一对多关联关系      添加功能
    @Test
    public void testSave(){
        // 创建一个用户
        Users users = new Users();
        users.setAddress("深圳");
        users.setAge(24);
        users.setName("老杨");
        // 创建一个角色
        Roles roles = new Roles();
        roles.setRolename("管理员");

        // 关联
        roles.getUsers().add(users);
        users.setRoles(roles);

        // 保存，sql语句会先操作roles角色表再操作users用户表
        this.usersJpaRepository.save(users);
    }

    // 一对多关联关系      查询功能
    @Test
    public void testFind(){

        // 根据id查出用户
        Users findById = this.usersJpaRepository.findById(7).get();
        System.out.println(findById);
        // 级联获取到用户的角色
        Roles roles = findById.getRoles();
        System.out.println(roles.getRolename());
    }





}
