package com.kevin.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author caonanqing
 * @version 1.0
 * @description     角色类
 * @createDate 2019/5/14
 */
public class Role implements Serializable {

    private String id;      // 主键
    private String name;    // 角色名
    private Set<Permission> permissions = new HashSet<Permission>();    // 对应的权限，一对多

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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
