package com.kevin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caonanqing
 * @version 1.0
 * @description     权限类
 * @createDate 2019/6/26
 */
@TableName("sys_permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPermission {

    /**
     * 自定id,主要供前端展示权限列表分类排序使用
     */
    @TableId(value = "permission_id",type = IdType.AUTO)
    private Integer permissionId;

    /**
     * 归属菜单,前端判断并展示菜单使用
     */
    @TableField("menu_code")
    private String menuCode;

    /**
     * 菜单的中文释义
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    @TableField("permission_url")
    private String permissionUrl;

    /**
     * 本权限的中文释义
     */
    @TableField("permission_name")
    private String permissionName;

    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    @TableField("required_permission")
    private Integer requiredPermission;

}
