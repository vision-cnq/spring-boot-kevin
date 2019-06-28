package com.kevin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     角色表
 * @createDate 2019/6/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class SysRole {

    /**
     * 主键
     */
    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名
     */
    @TableField("role_name")
    private String roleName;

    /**
     * 是否有效  1有效  2无效，默认为1
     */
    @TableField("status")
    private Integer status = 1;

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
     * 对应的权限，一对多
     */
    @TableField(exist=false)
    private List<SysPermission> permissions = new ArrayList<SysPermission>();

}
