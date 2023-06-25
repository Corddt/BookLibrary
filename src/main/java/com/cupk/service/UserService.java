package com.cupk.service;

import com.cupk.pojo.User;

import java.util.List;

public interface UserService {
    User findUserByID(Integer id);
    User findUserWithOrders(Integer id);
    List<User> findAllUsers();
}
