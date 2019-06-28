package com.kevin.entity;

import java.io.Serializable;

/**
 * @author caonanqing
 * @version 1.0
 * @description     权限类
 * @createDate 2019/5/14
 */
public class Permission implements Serializable {

    private String id;      // 主键
    private String name;    // 权限名称
    private String url;     // 权限url

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
