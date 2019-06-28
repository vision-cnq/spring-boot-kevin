package com.kevin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kevin.entity.SysPermission;
import com.kevin.mapper.SysPermissionMapper;
import com.kevin.mapper.SysUserMapper;
import com.kevin.entity.SysUser;
import com.kevin.service.LoginService;
import com.kevin.service.SysPermissionService;
import com.kevin.util.Result;
import com.kevin.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
@Service
public class LoginServiceImpl implements LoginService {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public void authLogin(String json) {

        JSONObject jsonObject = JSONObject.parseObject(json);
        String name = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        currentUser.login(token);
    }

    @Override
    public SysUser getUser(String name) {
        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>().lambda()
                .eq(SysUser::getName, name).eq(SysUser::getAccountStatus,1));
        return user;
    }

    @Override
    public Result getInfo() {

        Result result;
        try {
            // 从session中获取用户信息
            Session session = SecurityUtils.getSubject().getSession();
            SysUser sysUser = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
            String name = sysUser.getName();
            HashMap<String,Object> userPermission = sysPermissionService.getUserPermission(name);
            session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
            result = Result.ok();
            result.addInfo("userPermission",userPermission);
            logger.info(JSON.toJSONString(result));
        }catch (Exception e) {
            result = Result.fail();
            result.setMsg("获取用户权限失败");
            logger.error("获取用户权限失败: "+e.getMessage());
        }
        return result;
    }

}
