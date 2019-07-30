package com.kevin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.entity.Book;

import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
public interface BookService extends IService<Book> {

    //List<HashMap<String,Object>> getBooks();
    List<Book> getBooks();
}
