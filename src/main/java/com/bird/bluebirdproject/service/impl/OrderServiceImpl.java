package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.config.UserContext;
import com.bird.bluebirdproject.pojo.dto.OrderCreateDTO;
import com.bird.bluebirdproject.mapper.OrderMapper;
import com.bird.bluebirdproject.mapper.RouteLineMapper;
import com.bird.bluebirdproject.pojo.entity.Order;
import com.bird.bluebirdproject.pojo.entity.RouteLine;
import com.bird.bluebirdproject.service.OrderService;
import com.bird.bluebirdproject.pojo.vo.MyOrderVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单服务实现类
 * 实现订单相关的业务逻辑
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RouteLineMapper routeLineMapper;
    
    /**
     * 创建订单业务实现
     * 验证用户登录状态和线路存在性，构造订单对象并保存到数据库
     * @param dto 订单创建数据传输对象，包含线路ID、出行日期和人数
     * @param request HTTP请求对象，用于获取用户身份信息
     * @return 创建成功的订单ID
     */
    @Override
    public Result create(OrderCreateDTO dto, HttpServletRequest request) {
        Integer userId = UserContext.getUserId();
        if (userId == null) {
            return Result.error("未登录");
        }
        // 2. 查询线路，检查是否存在
        RouteLine line = routeLineMapper.selectById(dto.getLineId());
        if (line == null) {
            return Result.error("线路不存在");
        }
        // 3. 构造订单对象
        Order order = new Order();
        order.setUserId(userId);
        order.setLineId(dto.getLineId());
        order.setPlayDate(dto.getPlayDate());
        order.setQuantity(dto.getQuantity());
        order.setPrice(line.getPrice());
        order.setStatus("已预订");

        // 4. 插入数据库（useGeneratedKeys 会自动设置 order.id）
        orderMapper.insert(order);

        // 5. 返回订单 ID
        Map<String, Object> data = new HashMap<>();
        data.put("orderId", order.getId());

        return Result.success(data);
    }

    /**
     * 获取我的订单列表业务实现
     * 获取当前登录用户的订单列表，支持分页功能
     * @param page 页码
     * @param size 每页数量
     * @return 订单列表及分页信息
     */
    @Override
    public Result getMyOrders(Integer page, Integer size) {
        // 1. 获取当前用户 ID
        Integer userId = UserContext.getUserId();
        if (userId == null) {
            return Result.error("未登录");
        }

        // 2. 分页
        PageHelper.startPage(page, size);

        // 3. 查询订单
        List<MyOrderVO> list = orderMapper.selectMyOrders(userId);

        // 4. PageInfo 获取总数
        PageInfo<MyOrderVO> pageInfo = new PageInfo<>(list);

        // 5. 封装结果
        Map<String, Object> data = new HashMap<>();
        data.put("total", pageInfo.getTotal());
        data.put("list", pageInfo.getList());

        return Result.success(data);
    }

    /**
     * 取消订单业务实现
     * 验证订单所有权和状态，将符合条件的订单状态更新为"已取消"
     * @param orderId 订单ID
     * @return 取消结果
     */
    @Override
    public Result cancelOrder(Integer orderId) {
        // 1. 获取当前登录用户
        Integer userId = UserContext.getUserId();
        if (userId == null) {
            return Result.error("未登录");
        }

        // 2. 查询订单是否属于用户
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return Result.error("订单不存在");
        }
        // 3. 确保订单是当前用户的
        if (!order.getUserId().equals(userId)) {
            return Result.error("无权取消此订单");
        }

        // 4. 订单必须为 "已预订"
        if (!"已预订".equals(order.getStatus())) {
            return Result.error("该订单不可取消");
        }

        // 4. 执行取消
        orderMapper.updateStatus(orderId, "已取消");
        return Result.success("订单已取消");
    }
}