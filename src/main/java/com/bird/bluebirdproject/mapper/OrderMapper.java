package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.entity.Order;
import com.bird.bluebirdproject.pojo.vo.MyOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 插入订单
     * @param order 订单对象
     */
    void insert(Order order);

    /**
     * 查询当前用户的所有订单
     * @param userId 用户ID
     * @return 订单列表
     */
    List<MyOrderVO> selectMyOrders(@Param("userId") Integer userId);

    /**
     * 根据订单ID查询订单详情
     * @param id 订单ID
     * @return 订单详情
     */
    Order selectById(@Param("id") Integer id);

    /**
     * 更新订单状态
     * @param id 订单ID
     * @param status 订单状态
     */
    void updateStatus(@Param("id") Integer id, @Param("status") String status);
}
