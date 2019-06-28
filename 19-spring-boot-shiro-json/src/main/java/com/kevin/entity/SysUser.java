package com.kevin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUser {

    /**
     * 用户id，自增
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private Long userId;

    /**
     *  用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别 1:男 2：女
     */
    private String gender;

    /**
     * 部门id
     */
    @TableField("dept_id")
    private String deptId;

    /**
     * 账号状态 1:可用，2：禁用
     */
    @TableField("account_status")
    private Integer accountStatus;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 对应的权角色，一对多
     */
    @TableField(exist=false)
    private List<SysRole> permissions = new ArrayList<SysRole>();
}
