package com.kevin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
public interface CategoryMapper extends BaseMapper<Category> {

    @Select("SELECT id,name FROM category WHERE id = #{id}")
    Category getCategory(@Param("id") Integer id);
}
