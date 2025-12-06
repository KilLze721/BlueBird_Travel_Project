package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.Order;
import com.bird.bluebirdproject.pojo.vo.MyOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insert(Order order);

    List<MyOrderVO> selectMyOrders(@Param("userId") Integer userId);

    Order selectById(@Param("id") Integer id);

    void updateStatus(@Param("id") Integer id, @Param("status") String status);
}
