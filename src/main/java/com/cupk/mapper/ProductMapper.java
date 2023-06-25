package com.cupk.mapper;

import com.cupk.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("select * from t_product where id in" +
            "(select product_id from t_ordersitem where orders_id=#{id})")
    List<Product> selectProductByOrdersID(int orders_id);
}
