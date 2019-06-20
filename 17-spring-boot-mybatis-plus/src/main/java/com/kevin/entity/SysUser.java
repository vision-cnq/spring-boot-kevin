package com.kevin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author caonanqing
 * @version 1.0
 * @description     用户
 * @createDate 2019/5/16
 */
@Data
public class SysUser extends Model {

    /**
     * 主键
     */
    @TableId("id")
    private Integer id;
    /**
     * 用户名
     */
    @TableField("username")
    private String username;
    /**
     * 别名
     */
    @TableField("nickname")
    private String nickname;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 权限id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 权限名称
     */
    @TableField(exist = false)
    private String roleName;
    /**
     * 部门id
     */
    @TableField("dept_id")
    private Integer deptId;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;
    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * 是否删除(0:未删除 1:已删除)
     */
    @TableField("deleted")
    @TableLogic
    private Integer deleted;
    /**
     * 邮件
     */
    @TableField("email")
    private String email;
    /**
     * 电话
     */
    @TableField("phone")
    private String phone;


    @TableField("update_version")
    @Version
    private Integer updateVersion;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    //getter and setter
/*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUpdateVersion() {
        return updateVersion;
    }

    public void setUpdateVersion(Integer updateVersion) {
        this.updateVersion = updateVersion;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                ", id=" + id +
                ", username=" + username +
                ", nickname=" + nickname +
                ", password=" + password +
                ", roleId=" + roleId +
                ", deptId=" + deptId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark=" + remark +
                ", deleted=" + deleted +
                ", email=" + email +
                ", phone=" + phone +
                ", updateVersion=" + updateVersion +
                "}";
    }*/

}
