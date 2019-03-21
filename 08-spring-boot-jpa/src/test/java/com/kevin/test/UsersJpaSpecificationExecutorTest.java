package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.dao.UsersJpaSpecificationExecutor;
import com.kevin.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     测试JpaSpecificationExecutor功能，多条件查询
 * @createDate 2019/3/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UsersJpaSpecificationExecutorTest {

    @Autowired
    private UsersJpaSpecificationExecutor usersJpaSpecificationExecutor;

    // JpaSpecificationExecutor   单条件查询
    @Test
    public void testJpaSpecificationExecutor1(){

        // Specification<Users>：用于封装查询条件
        Specification<Users> specification = new Specification<Users>() {
            /**
                 Predicate：封装了单个的查询条件
                 Root<Users> root：查询对象的属性的封装
                 CriteriaQuery<?> query：封装了需要执行的查询中各个部分的信息，select from order by
                 CriteriaBuilder cb：查询条件的构造器，定义不同的查询条件
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // 定义查询条件：where name = 'coco'
                // cb.equal(arg0,arg1) 参数一：查询的属性。参数二：条件的值
                Predicate pre = cb.equal(root.get("name"), "coco");
                return pre;
            }
        };

        List<Users> list = this.usersJpaSpecificationExecutor.findAll(specification);
        for (Users user:list) {
            System.out.println(user);
        }
    }

    // JpaSpecificationExecutor   多条件查询，方式一
    @Test
    public void testJpaSpecificationExecutor2(){

        // Specification<Users>：用于封装查询条件
        Specification<Users> specification = new Specification<Users>() {
            /**
             Predicate：封装了单个的查询条件
             Root<Users> root：查询对象的属性的封装
             CriteriaQuery<?> query：封装了需要执行的查询中各个部分的信息，select from order by
             CriteriaBuilder cb：查询条件的构造器，定义不同的查询条件
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // 定义查询条件：where name = 'coco' and age = 20
                // cb.equal(arg0,arg1) 参数一：查询的属性。参数二：条件的值
                List<Predicate> list = new ArrayList<Predicate>();
                list.add(cb.equal(root.get("name"), "coco"));
                list.add(cb.equal(root.get("age"), "20"));
                // 定义Predicate[]，将list转为Predicate[]后返回
                Predicate[] arr = new Predicate[list.size()];
                return cb.and( list.toArray(arr));
            }
        };

        List<Users> list = this.usersJpaSpecificationExecutor.findAll(specification);
        for (Users user:list) {
            System.out.println(user);
        }
    }

    // JpaSpecificationExecutor   多条件查询，方式二
    @Test
    public void testJpaSpecificationExecutor3(){

        // Specification<Users>：用于封装查询条件
        Specification<Users> specification = new Specification<Users>() {
            /**
             Predicate：封装了单个的查询条件
             Root<Users> root：查询对象的属性的封装
             CriteriaQuery<?> query：封装了需要执行的查询中各个部分的信息，select from order by
             CriteriaBuilder cb：查询条件的构造器，定义不同的查询条件
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // cb.equal(arg0,arg1) 参数一：查询的属性。参数二：条件的值
                // 定义查询条件：where name = 'coco' and age = 20 or id = 1
                return cb.or(cb.and(cb.equal(root.get("name"), "coco"), cb.equal(root.get("age"), "20")),
                             cb.equal(root.get("id"), "1"));   // 先与后或
                //return cb.and(cb.equal(root.get("name"), "coco"),cb.equal(root.get("age"), "20"));   // 与
                //return cb.or(cb.equal(root.get("name"), "coco"),cb.equal(root.get("age"), "20"));      // 或

            }
        };
        // 如果需要做降序排序
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
        // 根据条件查询
        List<Users> list = this.usersJpaSpecificationExecutor.findAll(specification,sort);
        for (Users user:list) {
            System.out.println(user);
        }
    }

}
