package com.cupk.service.impl;

import com.cupk.mapper.BookMapper;
import com.cupk.pojo.Book;
import com.cupk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:BookServiceImpl
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-20 16:55
 */
@Service
@Primary
public class BookServiceImpl implements BookService {
    @Autowired(required = false)//表示根据类型完成自动注入
    private BookMapper bookMapper;
    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBookByID(Integer id) {
        return bookMapper.findBookByID(id);
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public int deleteBookByID(Integer id) {
        return bookMapper.deleteBookByID(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public List<Book> findBookByStr(String searchStr) {
        return bookMapper.findBookByStr(searchStr);
    }

    @Override
    public int deleteBooks(Integer[] ids) {
        int count=0;
        for(Integer id:ids)
        {
            count+=bookMapper.deleteBookByID(id);//逐个删除图书
        }
        return count;//返回删除的总数
    }

}
