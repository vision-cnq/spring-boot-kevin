package com.kevin.realm;

import com.kevin.entity.Permission;
import com.kevin.entity.Role;
import com.kevin.entity.User;
import com.kevin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author caonanqing
 * @version 1.0
 * @description     自定义Realm,实现授权与认证
 * @createDate 2019/5/14
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 用户授权
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {

        System.out.println("===执行授权===");
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        // 用户存在，不为null
        if(user != null){
            // 添加角色和权限
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 角色与权限字符串集合
            Collection<String> rolesCollection = new HashSet<>();
            Collection<String> premissionCollection = new HashSet<>();
            // 读取并赋值用户角色与权限
            Set<Role> roles = user.getRoles();
            for(Role role : roles){
                rolesCollection.add(role.getName());
                Set<Permission> permissions = role.getPermissions();
                for (Permission permission : permissions){
                    premissionCollection.add(permission.getUrl());
                }
                // 添加权限
                info.addStringPermissions(premissionCollection);
            }
            info.addRoles(rolesCollection);
            return info;
        }
        return null;
    }

    /**
     * 用户认证
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("===执行认证===");

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        // 从数据库获取对应用户名的用户
        User bean = userService.findByName(token.getUsername());
        if(bean == null){
            throw new UnknownAccountException("用户不存在");
        }
        // 获取盐值，即用户名
        ByteSource credentialsSalt = ByteSource.Util.bytes(bean.getName());
        // 数据库中的user密码必须是要经过md5加密，不然会抛出异常
        return new SimpleAuthenticationInfo(bean, bean.getPassword(),
                credentialsSalt, getName());
    }

    // 模拟Shiro用户加密，假设用户密码为123456
    public static void main(String[] args){
        // 用户名
        String username = "kevin";
        // 用户密码
        String password = "123456";
        // 加密方式
        String hashAlgorithName = "MD5";
        // 加密次数
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        Object obj = new SimpleHash(hashAlgorithName, password,
                credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}