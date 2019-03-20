package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kevin
 * @version 1.0
 * @description     Repository接口的使用：@Query的使用
 *
 * @createDate 2019/3/20
 */
@Transactional
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer> {

    // @Query查询
    // @Query 以对象HQL语句查询。根据名字作为条件查询
    @Query("from Users where name = :name")
    List<Users> queryByNameUseHQL(@Param("name") String name);

    // @Query 以对象SQL语句查询。根据名字作为条件查询,使用标准的SQL
    @Query(value="select * from t_users where name = ? ",nativeQuery = true)
    List<Users> queryByNameUseSQL(String name);

    // @Query更新
    // @Query根据id更新name
    @Query("update Users set name = :name where id = :id")
    @Modifying
    void updateUsersNameById(@Param("name")String name, @Param("id") Integer id);


}
