package com.kevin.entity;

import java.io.Serializable;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/22
 */
public class Users implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }@Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}