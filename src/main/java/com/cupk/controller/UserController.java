package com.cupk.controller;

import com.cupk.pojo.User;
import com.cupk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 名称:UserController
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-22 23:53
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/findbyid")
    public String findUserByID(Integer id, Model model){
        User user=userService.findUserByID(id);
        System.out.println(user);
        model.addAttribute("msg","User信息查询成功! ");
        return "public/success";
    }

    @RequestMapping("/finduwo")
    public String findUserWithOrders(Integer id,Model model){
        User user=userService.findUserWithOrders(id);
        if(user!=null){
            System.out.println(user);
            model.addAttribute("msg","User(含订单)信息查询成功! ");
            return "public/success";
        }
        else{
            model.addAttribute("msg","User(含订单)信息查询失败! ");
            return "public/false";
        }

    }

    @RequestMapping("/findall")
    public String findAllUser(Model model){
        List<User> users=userService.findAllUsers();
        if(users!=null){
            for(User u:users)
                System.out.println(u);
            model.addAttribute("msg","全部用户信息查询成功! ");
            return "public/success";
        }
        else{
            model.addAttribute("msg","全部用户信息查询失败! ");
            return "public/false";
        }

    }
}
