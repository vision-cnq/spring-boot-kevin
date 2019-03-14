package com.kevin.model;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/14
 */
public class Users {
    private String name;
    private String password;
    private Integer age;
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Users [name=" + name + ", password=" + password + ", age=" + age + "]";
    }

}
