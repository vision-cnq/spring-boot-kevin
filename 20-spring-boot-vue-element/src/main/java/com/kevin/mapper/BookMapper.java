package com.kevin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.entity.Book;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
public interface BookMapper extends BaseMapper<Book> {

    @Select("SELECT b.cover,b.title,b.author,b.date,b.press,b.abs,c.id,c.name FROM book b LEFT JOIN category c ON b.cid = c.id")
    @Results({
            @Result(column="cover",property="cover"),
            @Result(column="title",property="title"),
            @Result(column="author",property="author"),
            @Result(column="date",property="date"),
            @Result(column="press",property="press"),
            @Result(column="abs",property="abs"),
            @Result(column = "id", property = "category", one=@One(select = "com.kevin.mapper.CategoryMapper.getCategory", fetchType = FetchType.EAGER))
    })
    List<Book> getBooks();
}
