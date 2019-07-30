package com.kevin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import org.elasticsearch.common.settings.SecureString;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
@Data
@ToString
@TableName("books")
public class Book {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cover;

    private String title;

    private String author;

    private String date;

    private String press;

    private String abs;

    @TableField(exist = false)      // 该属性不为表字段
    private Category category;



}
