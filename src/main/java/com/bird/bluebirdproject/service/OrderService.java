package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.pojo.dto.OrderCreateDTO;
import jakarta.servlet.http.HttpServletRequest;


/**
 * 订单服务接口
 * 定义订单相关的业务逻辑接口
 */
public interface OrderService {
    /**
     * 创建订单业务逻辑
     * 根据线路ID、出行日期和人数创建订单
     * @param dto 订单创建数据传输对象，包含线路ID、出行日期和人数
     * @param request HTTP请求对象，用于获取用户身份信息
     * @return 创建成功的订单ID
     */
    Result create(OrderCreateDTO dto, HttpServletRequest request);

    /**
     * 获取我的订单列表业务逻辑
     * 分页获取当前用户的订单列表
     * @param page 页码
     * @param size 每页数量
     * @return 订单列表及分页信息
     */
    Result getMyOrders(Integer page, Integer size);

    /**
     * 取消订单业务逻辑
     * 根据订单ID取消对应的订单
     * @param orderId 订单ID
     * @return 取消结果
     */
    Result cancelOrder(Integer orderId);
}