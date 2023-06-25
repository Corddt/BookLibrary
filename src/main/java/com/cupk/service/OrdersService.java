package com.cupk.service;

import com.cupk.pojo.Orders;

public interface OrdersService {
    Orders selectOrdersByID(Integer id);
}
