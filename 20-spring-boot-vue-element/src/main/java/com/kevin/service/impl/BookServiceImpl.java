package com.kevin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.entity.Book;
import com.kevin.mapper.BookMapper;
import com.kevin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {

    @Autowired
    BookMapper booksMapper;

    @Override
    public List<Book> getBooks() {
        List<Book> books = booksMapper.getBooks();
        return books;
    }
}
