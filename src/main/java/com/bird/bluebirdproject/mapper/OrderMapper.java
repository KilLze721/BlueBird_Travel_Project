package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    void insert(Order order);
}
