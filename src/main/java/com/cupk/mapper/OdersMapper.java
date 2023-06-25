package com.cupk.mapper;

import com.cupk.pojo.Orders;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OdersMapper {
    @Select("select * from t_orders where user_id=#{id}")
    @Results({@Result(id = true,column = "id",property = "id"),
    @Result(column = "number",property = "number"),
    @Result(column = "price",property = "price")})
    List<Orders> selectOrdersByUserID(Integer user_id);

    @Select("select * from t_orders where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "number",property = "number"),
            @Result(column = "price",property = "price"),
            @Result(column = "id",property = "productList",
            many = @Many(select = "com.cupk.mapper.ProductMapper.selectProductByOrdersID"))
    })
    Orders selectOrdersByID(Integer id);

    @Select("select * from t_orders where user_id=#{user_id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "number",property = "number"),
            @Result(column = "price",property = "price"),
            @Result(column = "id",property = "productList",
                    many = @Many(select = "com.cupk.mapper.ProductMapper.selectProductByOrdersID"))
    })
    List<Orders> findAllOrdersByUid(Integer user_id);
}
