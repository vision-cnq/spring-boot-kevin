package com.kevin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
@Data
@ToString
@TableName("category")
public class Category {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    @TableField(value = "name")
    private String name;

}
