package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.dao.UsersPagingAndSortingRepository;
import com.kevin.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     测试PagingAndSortRepository排序与分页功能
 * @createDate 2019/3/20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UsersPagingAndSortingRepositoryTest {

    @Autowired
    private UsersPagingAndSortingRepository usersRepositoryPagingAndSorting;


    // PagingAndSortingRepository      排序功能
    @Test
    public void testPagingAndSortingRepositorySort(){
        // Order定义排序规则。降序
        Order order = new Order(Direction.DESC,"id");
        //Sort对象封装了排序规则
        Sort sort = new Sort(order);
        List<Users> list = (List<Users>)this.usersRepositoryPagingAndSorting.findAll(sort);
        for (Users user:list) {
            System.out.println(user.toString());
        }
    }

    // PagingAndSortingRepository      分页功能
    @Test
    public void testPagingAndSortingRepositoryPaging(){
        // Pageable：封装了分页的参数，当前页，每页显示的条数。注意：它的当前页从0开始
        // PageRequest（page,size）page：当前页。size：每页显示的条数
        Pageable pageable = new PageRequest(0,2);

        Page<Users> list = this.usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数："+list.getTotalElements());
        System.out.println("总页数："+list.getTotalPages());

        for (Users user:list) {
            System.out.println(user.toString());
        }
    }

    // PagingAndSortingRepository      排序+分页功能
    @Test
    public void testPagingAndSortingRepositorySortAndPaging(){

        // 根据id进行升序排序
        Sort sort = new Sort(new Order(Direction.ASC,"id"));
        // 根据0开始显示两条数据，并排序
        Pageable pageable = new PageRequest(0,2,sort);

        Page<Users> list = this.usersRepositoryPagingAndSorting.findAll(pageable);
        System.out.println("总条数："+list.getTotalElements());
        System.out.println("总页数："+list.getTotalPages());

        for (Users user:list) {
            System.out.println(user.toString());
        }
    }



}
