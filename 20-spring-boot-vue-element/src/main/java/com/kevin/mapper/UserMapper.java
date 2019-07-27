package com.kevin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/27
 */
public interface UserMapper extends BaseMapper <User>{

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getName(@Param("username") String username);

    @Select("SELECT id,username,password FROM user WHERE username = #{username} and password = #{password}")
    User get(@Param("username") String username,@Param("password") String password);

}
