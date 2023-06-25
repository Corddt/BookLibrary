package com.cupk.pojo;

import lombok.Data;

import java.util.List;

/**
 * 名称:User
 * 描述:数据库t_user对应实体类
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-22 23:20
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private IDCard card;
    private List<Orders> ordersList;//用户关联的订单
}
