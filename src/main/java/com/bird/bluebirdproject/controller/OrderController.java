package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.pojo.dto.OrderCreateDTO;
import com.bird.bluebirdproject.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单控制器类
 * 处理订单相关的HTTP请求，包括创建订单、查看订单列表和取消订单等功能
 */
@Tag(name = "订单接口")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单接口
     * 根据线路ID、出行日期和人数创建订单
     * 用户ID由后端从Token中解析获取，不需要前端传递
     * @param dto 订单创建数据传输对象，包含线路ID、出行日期和人数
     * @param request HTTP请求对象，用于获取用户身份信息
     * @return 创建成功的订单ID
     */
    @Operation(summary = "创建订单")
    @PostMapping("/create")
    public Result create(@RequestBody OrderCreateDTO dto, HttpServletRequest request) {
        return orderService.create(dto, request);
    }

    /**
     * 获取我的订单列表
     * 分页获取当前用户的订单列表
     * @param page 页码，默认为1
     * @param size 每页数量，默认为10
     * @return 订单列表及分页信息
     */
    @Operation(summary = "获取订单列表")
    @GetMapping("/mycreate")
    public Result myOrders(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return orderService.getMyOrders(page, size);
    }

    /**
     * 取消订单接口
     * 根据订单ID取消对应的订单
     * @param id 订单ID
     * @return 取消结果
     */
    @Operation(summary = "取消订单")
    @PutMapping("/{id}/cancel")
    public Result cancelOrder(@PathVariable Integer id) {
        return orderService.cancelOrder(id);
    }
}