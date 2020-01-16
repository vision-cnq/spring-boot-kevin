package com.kevin.submeter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2020/1/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tab_user")
public class User {

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField("name")
    private String name;
    /**
     * 性别
     */
    @TableField("sex")
    private String sex;
    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
