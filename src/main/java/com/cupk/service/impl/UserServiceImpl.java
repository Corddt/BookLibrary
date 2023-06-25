package com.cupk.service.impl;

import com.cupk.mapper.UserMapper;
import com.cupk.pojo.User;
import com.cupk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 名称:UserServiceImpl
 * 描述:
 *
 * @version 1.0
 * @author:zjf
 * @datatime:2023-06-22 23:45
 */
@Service
@Primary
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public User findUserByID(Integer id) {
        return userMapper.findUserByID(id);
    }

    @Override
    public User findUserWithOrders(Integer id) {
        return userMapper.findUserWithOrders(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }
}
