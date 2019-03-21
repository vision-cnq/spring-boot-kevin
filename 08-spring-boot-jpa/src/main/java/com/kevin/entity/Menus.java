package com.kevin.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kevin
 * @version 1.0
 * @description     菜单表
 *      多对多
 *      多个菜单对应多个角色
 * @createDate 2019/3/21
 */
@Entity
@Table(name = "t_menus")
public class Menus {

    @Id     // 表示主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 主键规则
    @Column(name = "menusid")   // 列名
    private Integer menusid;

    @Column(name = "menusname")
    private String menusname;

    @Column(name = "menusurl")
    private String menusurl;

    @Column(name = "fatherid")
    private Integer fatherid;

    @ManyToMany(mappedBy = "menus")     // 多对多，mappedBy：Roles中关联的字段名称
    private Set<Roles> roles = new HashSet<>();

    public Integer getMenusid() {
        return menusid;
    }

    public void setMenusid(Integer menusid) {
        this.menusid = menusid;
    }

    public String getMenusname() {
        return menusname;
    }

    public void setMenusname(String menusname) {
        this.menusname = menusname;
    }

    public String getMenusurl() {
        return menusurl;
    }

    public void setMenusurl(String menusurl) {
        this.menusurl = menusurl;
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "menusid=" + menusid +
                ", menusname='" + menusname + '\'' +
                ", menusurl='" + menusurl + '\'' +
                ", fatherid=" + fatherid +
                '}';
    }
}
