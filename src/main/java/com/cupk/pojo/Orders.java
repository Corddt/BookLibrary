package com.cupk.pojo;

import lombok.Data;

import java.util.List;

/**
 * 名称:Orders
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-23 14:12
 */
@Data
public class Orders {
    private Integer id;
    private String number;
    private Double price;

    List<Product> productList;//订单包含的商品

}
