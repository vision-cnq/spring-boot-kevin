package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author kevin
 * @version 1.0
 * @description     SpringBoot整合JPA
 *      Spring Data：Spring Data是Spring提供了一个操作数据的框架。而Spring Data Jpa只是Spring Data框架下的一个基于JPA标准操作数据的模块。
 *      Spring Data JPA：基于JPA的标准对数据进行操作。简化操作持久层的代码。只需要编写接口就可以了。
 *
 *   Spring Data JPA提供的核心接口：
 *      1.Repository接口
 *          提供方法名称命名查询方式
 *          提供基于@Query注解查询与更新
 *      2.CrudRepository接口
 *      3.PagingAndSortingRepository接口
 *      4.JpaRepository接口
 *      5.JPASpecificationExecutor接口
 *
 * @createDate 2019/3/20
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kevin.dao")
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class,args);
    }
}
