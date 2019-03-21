package com.kevin.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kevin
 * @version 1.0
 * @description     角色实体类
 *      一对多
 *      一个角色对应多个用户
 * @createDate 2019/3/21
 */
@Entity
@Table(name = "t_roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleid")
    private Integer roleid;

    @Column(name="rolename")
    private String rolename;

    @OneToMany(mappedBy = "roles")  // 一对多
    private Set<Users> users = new HashSet<>();     // 多个用户

    // cascade = CascadeType.PERSIST：开启级联操作。fetch = FetchType.EAGER：设置为立即加载。
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)         // 多对多
    // @JoinTable：映射中间表信息，name：中间表的表名，joinColumns：当前表中的主键所关联的中间表中的外键
    @JoinTable(name = "t_roles_menus", joinColumns = @JoinColumn(name = "role_id"),inverseJoinColumns = @JoinColumn(name = "menus_id"))
    private Set<Menus> menus = new HashSet<>();

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Set<Menus> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menus> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", users=" + users +
                ", menus=" + menus +
                '}';
    }
}
