package com.kevin.submeter.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * @author caonanqing
 * @version 1.0
 * @description     自定义雪花算法
 *      使用方法(配置法)：
 *          1.在resources目录下新建META-INF文件夹，再新建services文件夹
 *          2.然后新建文件的名字为org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator
 *          3.打开文件：复制自定义分布式主键的类全路径到文件中保存
 *              com.kevin.submeter.config.MySnowflakeKeyGenerator
 * @createDate 2020/1/14
 */
public class MySnowflakeKeyGenerator implements ShardingKeyGenerator {

    private static final Snowflake snowflake = IdUtil.createSnowflake(1, 1);

    @Override
    public Comparable<?> generateKey() {
        return snowflake.nextId();
    }

    @Override
    public String getType() {
        return "MYSNOWFLAKE";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
