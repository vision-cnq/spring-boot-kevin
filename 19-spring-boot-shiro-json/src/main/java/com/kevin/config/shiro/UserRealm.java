package com.kevin.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.kevin.entity.SysUser;
import com.kevin.service.LoginService;
import com.kevin.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author caonanqing
 * @version 1.0
 * @description     自定义Realm
 * @createDate 2019/6/26
 */
public class UserRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static final String SALT = "ldsdkkP36";

    @Autowired
    private LoginService loginService;

    /**
     * 用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("==========用户授权==========");
        Session session = SecurityUtils.getSubject().getSession();
        //查询用户的权限
        HashMap<String,Object> permission = (HashMap<String,Object>) session.getAttribute(Constants.SESSION_USER_PERMISSION);
        logger.info("permission的值为: [{}]", permission);
        logger.info("本用户权限为: [{}]", permission.get("permissionList"));
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions((Collection<String>) permission.get("permissionList"));
        return authorizationInfo;
    }

    /**
     * 用户认证，验证当前登录的Subject
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info("==========用户认证==========");
        String loginName = (String) authenticationToken.getPrincipal();
        // 获取用户密码
        SysUser user = loginService.getUser(loginName);
        if (user == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getName()), //salt=username+salt,采用明文访问时，不需要此句
                getName()
        );
        //session中不需要保存密码
        //user.setPassword(null);
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);
        return authenticationInfo;
    }

    // 模拟Shiro用户加密，假设用户密码为123456
    public static void main(String[] args){
        // 用户名
        String username = "admin";
        // 用户密码
        String password = "123456";
        // 加密方式
        String hashAlgorithName = "MD5";
        // 加密次数
        int hashIterations = 2;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object obj = new SimpleHash(hashAlgorithName, password,
                credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
