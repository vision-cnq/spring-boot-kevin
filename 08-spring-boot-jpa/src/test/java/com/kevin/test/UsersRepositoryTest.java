package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.dao.UsersJpaRepository;
import com.kevin.dao.UsersRepositoryByName;
import com.kevin.dao.UsersRepositoryQueryAnnotation;
import com.kevin.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     测试Repository功能，方法名称命名与@Quert功能
 * @createDate 2019/3/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UsersRepositoryTest {

    @Autowired
    private UsersRepositoryByName usersRepositoryByName;

    @Autowired
    private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

    // Repository---方法名称命名测试,根据名字作为条件查询
    @Test
    public void testFindByName(){

        List<Users> list  = this.usersRepositoryByName.findByName("kevin");
        for (Users user : list) {
            System.out.println(user.toString());
        }
    }

    // Repository---方法名称命名测试，根据名字和年龄作为条件查询
    @Test
    public void testFindByNameAndAge(){

        List<Users> list  = this.usersRepositoryByName.findByNameAndAge("kevin",22);
        for (Users user : list) {
            System.out.println(user.toString());
        }
    }

    // Repository---方法名称命名测试，根据名字做通配符查询
    @Test
    public void testFindByNameLike(){

        List<Users> list  = this.usersRepositoryByName.findByNameLike("co%");
        for (Users user : list) {
            System.out.println(user.toString());
        }
    }

    // Repository---@Quert测试，根据名字查询HQL
    @Test
    public void testQueryByNameUseHQL(){

        List<Users> list  = this.usersRepositoryQueryAnnotation.queryByNameUseHQL("coco");
        for (Users user : list) {
            System.out.println(user.toString());
        }
    }

    // Repository---@Quert测试，根据名字查询SQL
    @Test
    public void testQueryByNameUseSQL(){

        List<Users> list  = this.usersRepositoryQueryAnnotation.queryByNameUseSQL("kevin");
        for (Users user : list) {
            System.out.println(user.toString());
        }
    }

    // Repository---@Quert测试，根据id更新name
    @Test
    @Transactional      //@Transactional与@Test一起使用时，会自动回滚
    @Rollback(false)        // 取消自动回滚
    public void testUpdateUsersNameById(){

        this.usersRepositoryQueryAnnotation.updateUsersNameById("tomcat",1);

    }


}
