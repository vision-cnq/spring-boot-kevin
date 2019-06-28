package com.kevin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/6/27
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询用户列表
     */
    List<HashMap<String,Object>> listUser(@Param("offset") int offset, @Param("pageRow") int pageRow);
}
