package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author kevin
 * @version 1.0
 * @description     PagingAndSortingRepository的使用。主要是排序，分页等
 * @createDate 2019/3/20
 */
public interface UsersPagingAndSortingRepository extends PagingAndSortingRepository<Users,Integer> {

}
