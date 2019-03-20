package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.dao.UsersCrudRepository;
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
 * @description        测试CrudRepository功能
 * @createDate 2019/3/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UsersCrudRepositoryTest {

    @Autowired
    private UsersCrudRepository usersCrudRepository;


    // CrudRepository测试,新增功能
    @Test
    public void testCrudRepositorySave(){
        Users user = new Users();
        user.setAddress("上海");
        user.setAge(22);
        user.setName("java");
        this.usersCrudRepository.save(user);
    }

    // CrudRepository测试,更新功能,save方法即是插入又是更新
    @Test
    public void testCrudRepositoryUpdate(){
        Users user = new Users();
        user.setAddress("上海");
        user.setAge(22);
        user.setName("scala");
        user.setId(4);
        this.usersCrudRepository.save(user);
    }

    // CrudRepository测试,查询功能，根据id查询
    @Test
    public void testCrudRepositoryFindById(){
        Users user = this.usersCrudRepository.findById(1).get();
        System.out.println(user.toString());
    }

    // CrudRepository测试,查询功能，查询全部
    @Test
    public void testCrudRepositoryFindAll(){

        List<Users> users = (List<Users>) this.usersCrudRepository.findAll();
        for (Users user:users) {
            System.out.println(user);
        }
    }

    // CrudRepository测试,删除功能，根据id删除
    @Test
    public void testCrudRepositoryDeleteById(){

        this.usersCrudRepository.deleteById(5);
    }

}
