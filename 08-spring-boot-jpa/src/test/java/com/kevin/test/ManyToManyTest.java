package com.kevin.test;

import com.kevin.JpaApplication;
import com.kevin.dao.RolesJpaRepository;
import com.kevin.entity.Menus;
import com.kevin.entity.Roles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author kevin
 * @version 1.0
 * @description     测试多对多关联
 * @createDate 2019/3/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class ManyToManyTest {

    @Autowired
    private RolesJpaRepository rolesJpaRepository;

    // 多对多关联关系      添加功能
    @Test
    public void testSave(){

        // 创建角色对象
        Roles r = new Roles();
        r.setRolename("项目经理");

        // 创建菜单对象
        Menus menus = new Menus();
        menus.setMenusname("xxx管理系统");
        menus.setFatherid(0);

        Menus menus2 = new Menus();
        menus2.setMenusname("项目管理");
        menus2.setFatherid(1);

        // 关联
        r.getMenus().add(menus);
        r.getMenus().add(menus2);
        menus.getRoles().add(r);
        menus2.getRoles().add(r);
        // 保存
        this.rolesJpaRepository.save(r);

    }

    // 多对多关联关系      查询功能
    @Test
    public void testFind(){
        Roles roles = this.rolesJpaRepository.findById(2).get();
        System.out.println(roles.getRolename());
        Set<Menus> menus = roles.getMenus();
        for (Menus menus2:menus) {
            System.out.println(menus2);
        }
        
    }


}
