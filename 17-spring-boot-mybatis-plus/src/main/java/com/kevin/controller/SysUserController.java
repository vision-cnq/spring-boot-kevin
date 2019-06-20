package com.kevin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.kevin.entity.SysUser;
import com.kevin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * @author caonanqing
 * @version 1.0
 * @description     用户前端控制类
 * @createDate 2019/5/16
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    private final static Gson GSON = new Gson();


    /**
     * 测试根据id查询单条数据
     */
    @GetMapping(value = "get")
    public String get(){
        //测试根据id查询单条数据
        SysUser sysUser = sysUserService.getById(1);
        return GSON.toJson(sysUser);

    }

    /**
     * 测试分页查询
     */
    @GetMapping(value = "page")
    public void page(){
        //测试分页
        IPage<SysUser> sysUserIPage = sysUserService.page(
                new Page<SysUser>(1, 10), new QueryWrapper<>());
    }

    /**
     * 测试公共字段自动填充
     */
    @GetMapping(value = "auto")
    public void fieldAutoFill(){
        //测试公共字段自动填充
        SysUser sysUser1 = new SysUser();
        sysUser1.setId(2);
        sysUser1.setUsername("shen");
        sysUser1.setNickname("shen");
        sysUser1.setPassword("shen");
        sysUserService.save(sysUser1);
    }

    /**
     * 测试乐观锁
     */
    @GetMapping(value = "lock")
    public void optimisticLock(){

        //测试乐观锁
        SysUser sysUser2 = new SysUser();
        sysUser2.setId(19);
        sysUser2.setUsername("shen2");
        sysUser2.setNickname("shen2");
        sysUser2.setPassword("shen2");
        sysUser2.setUpdateVersion(1);

        sysUserService.updateById(sysUser2);

    }




}
