package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.config.UserContext;
import com.bird.bluebirdproject.pojo.dto.OrderCreateDTO;
import com.bird.bluebirdproject.mapper.OrderMapper;
import com.bird.bluebirdproject.mapper.RouteLineMapper;
import com.bird.bluebirdproject.pojo.Order;
import com.bird.bluebirdproject.pojo.RouteLine;
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

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RouteLineMapper routeLineMapper;
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
}
