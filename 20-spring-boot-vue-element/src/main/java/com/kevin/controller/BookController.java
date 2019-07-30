package com.kevin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.kevin.entity.Book;
import com.kevin.service.BookService;
import com.kevin.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/7/30
 */
@RequestMapping("/api")
@RestController
public class BookController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public Result getBooks(){
        Result result;
        List<Book> books = bookService.getBooks();
        if(books == null || books.size()<1){
            result = Result.fail();
        } else {
            result = Result.ok("books",books);
        }
        logger.info(result.getMsg());
        return result;
    }
}
