package com.kevin.entity;

/**
 * @author kevin
 * @version 1.0
 * @description     邮箱实体类
 * @createDate 2019/3/20
 */
public class Emps {

    private Integer id;
    private String name;
    private String email;

    public Emps() {
    }

    public Emps(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
