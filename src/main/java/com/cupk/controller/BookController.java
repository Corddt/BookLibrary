package com.cupk.controller;

import com.cupk.pojo.Book;
import com.cupk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 名称:BookController
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-20 17:08
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired(required = false)
    private BookService bookService;

    //跳转到系统首页
    @RequestMapping("/index")
    public String toIndex(){
        return "index";//index.html
    }
    //跳转到添加图书页面
    @RequestMapping("/toinsert")
    public String toInsert(){
        return "book/insertbook";//insertbook.html
    }
    //添加图书信息
    @RequestMapping("/insert")
    public String insertBook(Book book,Model model){
        System.out.println("新增图书信息: "+book);
        int i=bookService.insertBook(book);
        if(i>0){
            List<Book> bookList=bookService.findAllBooks();
            model.addAttribute("blist",bookList);
            model.addAttribute("msg","添加图书信息成功! ");
            return "book/booklist";
        }else {
            return "public/false";
        }
    }

    //查询全部图书
    @RequestMapping("/findall")
    public String findAllBooks(Model model){
        List<Book> bookList=bookService.findAllBooks();
        for (Book book:bookList)
            System.out.println(book.getName()+" "+book.getISBN()+" "+book.getPrice());
        model.addAttribute("blist",bookList);//存储全部图书信息
        return "book/booklist";
    }

    //根据图书编号查询图书
    @GetMapping("/findbyid")
    public Book findBookByID(@RequestParam(name="id") Integer id){
        Book book= bookService.findBookByID(id);
        System.out.println(book);
        return book;
    }

    @RequestMapping("/deletebyid/{id}")
    public String deleteBookByID(@PathVariable("id") Integer id, Model model){
        int i=bookService.deleteBookByID(id);
        if(i>0){
            List<Book> bookList=bookService.findAllBooks();
            model.addAttribute("blist",bookList);
            model.addAttribute("msg","删除图书信息成功! ");
            return "book/booklist";
        }else {
            return "public/false";
        }
    }

    //跳转到图书修改页面
    @RequestMapping("/toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Book book=bookService.findBookByID(id);
        model.addAttribute("book",book);
        return "book/updatebook";
    }

    //修改图书信息
    @RequestMapping("/update")
    public String updateBook(Book book,Model model){
        int i=bookService.updateBook(book);
        if(i>0){
            List<Book> bookList=bookService.findAllBooks();
            model.addAttribute("blist",bookList);
            model.addAttribute("msg","修改图书信息成功! ");
            return "book/booklist";
        }else {
            return "public/false";
        }
    }

    @RequestMapping("/findbystr")
    public String findBookByStr(@RequestParam(value = "searchStr") String searchStr,Model model){
        List<Book> bookList=bookService.findBookByStr(searchStr);
        model.addAttribute("blist",bookList);
        return "book/booklist";
    }

    @RequestMapping("/delete")
    public String deleteBooks(Integer[] bookids,Model model){
        if(bookids!=null){
            int i=bookService.deleteBooks(bookids);
            if(i>0){
                List<Book> bookList=bookService.findAllBooks();
                model.addAttribute("blist",bookList);
                model.addAttribute("msg","批量删除图书信息成功! ");
                return "book/booklist";
            }else {
                return "public/false";
            }
        }
        else{
            model.addAttribute("msg","未选择任何图书，无法删除! ");
            return "public/false";
        }
    }
}
