package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description         测试JpaRepository，具体功能最多
 * @createDate 2019/3/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UsersJpaRepositoryTest {

    @Autowired
    private com.kevin.dao.UsersJpaRepository usersJpaRepository;

    // JpaRepository   新增或更新功能，save方法会判断，如果数据库没有该条数据则插入，存在则更新
    @Test
    public void testSave(){
        Users users = new Users();
        users.setAddress("广州");
        users.setAge(22);
        users.setName("cnq");
        this.usersJpaRepository.save(users);
    }

    // JpaRepository    查询功能，根据id查询
    @Test
    public void testFindById(){
        Users user = this.usersJpaRepository.findById(1).get();
        System.out.println(user);
    }

    // JpaRepository    查询功能，查询全部
    @Test
    public void testFindAll(){
        List<Users> list = this.usersJpaRepository.findAll();
        for (Users user:list) {
            System.out.println(user);
        }
    }

    // JpaRepository    删除功能，根据id查询
    @Test
    public void testDeleteById(){
        this.usersJpaRepository.deleteById(6);
    }

    // JpaRepository    删除功能，根据对象删除
    @Test
    public void testDelete(){
        Users users = new Users();
        users.setAddress("广州");
        users.setAge(22);
        users.setName("cnq");
        users.setId(6);
        this.usersJpaRepository.delete(users);
    }




}
