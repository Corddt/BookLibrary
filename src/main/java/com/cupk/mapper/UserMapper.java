package com.cupk.mapper;

import com.cupk.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from t_user where id=#{id}")
    @Results({@Result(column = "card_id",property = "card",
    one = @One(select = "com.cupk.mapper.IDCardMapper.findCardByID"))})
    User findUserByID(Integer id);

    @Select("select * from t_user where id=#{id}")
    @Results({@Result(id = true,column = "id",property = "id"),
    @Result(column = "name",property = "name"),
    @Result(column = "password",property = "password"),
    @Result(column = "email",property = "email"),
    @Result(column = "id",property = "ordersList",
    many = @Many(select = "com.cupk.mapper.OdersMapper.selectOrdersByUserID"))})
    User findUserWithOrders(Integer id);

    @Select("select * from t_user")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "password",property = "password"),
            @Result(column = "email",property = "email"),
            @Result(column = "id",property = "ordersList",
            many = @Many(select = "com.cupk.mapper.OdersMapper.findAllOrdersByUid"))})
    List<User> findAllUsers();
}
