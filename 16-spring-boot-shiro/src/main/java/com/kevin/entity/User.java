package com.kevin.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author caonanqing
 * @version 1.0
 * @description     用户类
 * @createDate 2019/5/14
 */
public class User implements Serializable {

    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 对应的角色，一对多
     */
    private Set<Role> roles = new HashSet<Role>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
