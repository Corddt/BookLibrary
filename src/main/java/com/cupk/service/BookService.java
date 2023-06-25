package com.cupk.service;

import com.cupk.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();//查找全部图书
    Book findBookByID(Integer id);//根据图书编号查询图书
    int insertBook(Book book);//添加图书
    int deleteBookByID(Integer id);//根据图书编号删除图书
    int updateBook(Book book);//修改图书信息
    List<Book> findBookByStr(String searchStr);//模糊查询图书
    int deleteBooks(Integer[] ids);//批量删除图书
}
