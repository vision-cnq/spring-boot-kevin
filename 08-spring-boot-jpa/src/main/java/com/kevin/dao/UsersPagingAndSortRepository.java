package com.kevin.dao;

import com.kevin.entity.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author kevin
 * @version 1.0
 * @description     PagingAndSortingRepository的使用
 * @createDate 2019/3/20
 */
public interface UsersPagingAndSortRepository extends PagingAndSortingRepository<Users,Integer> {
}
