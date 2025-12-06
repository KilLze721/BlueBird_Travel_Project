package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.service.RouteLineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 旅游线路控制器类
 * 处理旅游线路相关的HTTP请求，包括线路列表展示和线路详情查看等功能
 */
@Tag(name = "旅游线路接口")
@RestController
@RequestMapping("/route")
public class RouteLineController {
    @Autowired
    private RouteLineService routeLineService;

    /**
     * 获取线路列表（含筛选）
     * 支持按线路名称和类型ID进行筛选，并支持分页功能
     * @param page 页码，默认为1
     * @param size 每页数量，默认为20
     * @param name 线路名称（模糊查询）
     * @param typeId 线路类型ID
     * @return 线路列表及分页信息
     */
    @Operation(summary = "获取线路列表")
    @GetMapping("/lines")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer typeId) {

        return routeLineService.getRouteList(page, size, name, typeId);
    }

    /**
     * 获取线路详情
     * 根据线路ID获取线路的详细信息
     * @param id 线路ID
     * @return 线路详细信息
     */
    @Operation(summary = "获取线路详情")
    @GetMapping("/lines/{id}")
    public Result detail(@PathVariable Integer id) {
        return routeLineService.getDetail(id);
    }
}