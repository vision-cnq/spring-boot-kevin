package com.kevin.entity;

import javax.persistence.*;

/**
 * @author kevin
 * @version 1.0
 * @description     用户实体类
 * @createDate 2019/3/20
 */
@Entity     // 表示该类为实体类
@Table(name="t_users")      // 对应数据库中的表名
public class Users {

    @Id     // 表示为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 该主键的策略
    @Column(name = "id")        // 列名
    private Integer id;
    @Column(name = "name")      // 列名
    private String name;
    @Column(name = "age")       // 列名
    private Integer age;
    @Column(name = "address")   // 列名
    private String address;

    @ManyToOne(cascade = CascadeType.PERSIST)      // ManyToOne表示多对一，cascade = CascadeType.PERSIST属性是级联操作
    @JoinColumn(name = "roles_id")   // 维护外键
    private Roles roles;        // 对应的角色

    public Users() {
    }

    public Users(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
