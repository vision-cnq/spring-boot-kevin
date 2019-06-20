package com.kevin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * @author caonanqing
 * @version 1.0
 * @description     配置公共字段自动填充功能，@TableField(..fill = FieldFill.INSERT)
 * @createDate 2019/5/16
 */
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        Object createTime = getFieldValByName("createTime", metaObject);
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (createTime == null)
            setFieldValByName("createTime",new Date(), metaObject);//mybatis-plus版本2.0.9+
        if (updateTime == null)
            setFieldValByName("updateTime",new Date(), metaObject);//mybatis-plus版本2.0.9+
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
    }
}

