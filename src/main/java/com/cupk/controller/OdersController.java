package com.cupk.controller;

import com.cupk.pojo.Orders;
import com.cupk.service.OrdersService;
import com.cupk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 名称:OdersController
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-23 17:40
 */
@Controller
@RequestMapping("/orders")
public class OdersController {
    @Autowired(required = false)
    private OrdersService ordersService;

    @RequestMapping("/selectbyid")
    public String selectOrdersByID(Integer id, Model model){
        Orders orders=ordersService.selectOrdersByID(id);
        if(orders!=null){
            System.out.println(orders);
            model.addAttribute("msg","订单信息查询成功! ");
            return "public/success";
        }
        else{
            model.addAttribute("msg","订单信息查询失败! ");
            return "public/false";
        }
    }
}
