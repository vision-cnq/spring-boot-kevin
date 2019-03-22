package com.kevin.test;

import com.kevin.EhcacheApplication;
import com.kevin.entity.Users;
import com.kevin.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author kevin
 * @version 1.0
 * @description     测试ehcache缓存
 * @createDate 2019/3/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EhcacheApplication.class)
public class UserServiceTest {

    @Autowired
    private UsersService usersService;

    // ehcache缓存测试@Cacheable，默认key        在findUserById查询方法中加入缓存，第一次查询时查询了数据库，第二次直接从缓存取出
    @Test
    public void testFindUserById(){
        // 第一次查询
        Users user = this.usersService.findUserById(1);
        System.out.println(user);

        // 第二次查询
        Users user2 = this.usersService.findUserById(1);
        System.out.println(user2);

    }

    // ehcache缓存测试@Cacheable，自定义key
    @Test
    public void testFindUserByPage(){
        // 设置分页
        Pageable pageable = new PageRequest(0,2);
        // 第一次查询
        Page<Users> user = this.usersService.findUserByPage(pageable);
        System.out.println(user.getTotalElements());
        for (Users u:user) {
            System.out.println(u);
        }

        // 第二次查询
        Page<Users> user1 = this.usersService.findUserByPage(pageable);
        System.out.println(user.getTotalElements());
        for (Users u:user1) {
            System.out.println(u);
        }

        // 第三次查询
        pageable = new PageRequest(1, 2);
        Page<Users> user2 = this.usersService.findUserByPage(pageable);
        System.out.println(user.getTotalElements());
        for (Users u:user2) {
            System.out.println(u);
        }
    }


    // ehcache缓存测试@CacheEvict，清空缓存
    @Test
    public void testFindAll(){

        // 第一次查询，查询数据记录长度
        System.out.println(this.usersService.findUserAll().size());

        // 增加，长度加一
        Users users = new Users();
        users.setName("小波");
        users.setAge(24);
        users.setAddress("湛江");
        this.usersService.saveUsers(users);

        // 第二次查询，如果不清除缓存，则还是取到之前的数据，所以需要将缓存清除
        System.out.println(this.usersService.findUserAll().size());

    }


}
