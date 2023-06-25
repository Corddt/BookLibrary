package com.cupk.mapper;

import com.cupk.pojo.IDCard;
import org.apache.ibatis.annotations.Select;

public interface IDCardMapper {
    @Select("select * from t_idcard where id=#{id}")
    IDCard findCardByID(Integer id);
}
