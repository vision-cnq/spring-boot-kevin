package com.kevin.mapper;

import com.kevin.entity.Emps;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     使用注解形式获取数据的数据
 * @createDate 2019/3/20
 */
public interface EmpsMapper {

    @Select("select * from emps")
    List<Emps> selectEmps();
}
