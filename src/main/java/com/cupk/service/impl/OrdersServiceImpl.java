package com.cupk.service.impl;

import com.cupk.mapper.OdersMapper;
import com.cupk.mapper.UserMapper;
import com.cupk.pojo.Orders;
import com.cupk.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 名称:OrdersServiceImpl
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-23 17:35
 */
@Service
@Primary
public class OrdersServiceImpl implements OrdersService {
    @Autowired(required = false)
    private OdersMapper odersMapper;
    @Override
    public Orders selectOrdersByID(Integer id) {
        return odersMapper.selectOrdersByID(id);
    }
}
