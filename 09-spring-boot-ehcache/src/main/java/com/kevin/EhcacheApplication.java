package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author kevin
 * @version 1.0
 * @description     SpringBoot整合Ehcache缓存
 *
 *   @Cacheable与@CacheEvict
 *      @Cacheable作用：将方法的返回值添加到Ehcache中做缓存。
 *          Value属性：指定ehcache配置文件中的缓存策略。如果没给定Value，则使用默认的缓存策略
 *          key属性：给缓存中的值起个名称，在查询时如果有名称相同的，则从已知缓存中将数据返回。
 *      @CacheEvict作用：清除缓存。
 *
 *
 * @createDate 2019/3/21
 */
@SpringBootApplication
@EnableCaching      // 启动缓存
public class EhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhcacheApplication.class,args);
    }
}
