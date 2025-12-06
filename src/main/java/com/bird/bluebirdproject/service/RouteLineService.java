package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.common.Result;

/**
 * 旅游线路服务接口
 * 定义旅游线路相关的业务逻辑接口
 */
public interface RouteLineService {
    /**
     * 获取线路列表（含筛选）
     * 支持按线路名称和类型ID进行筛选，并支持分页功能
     * @param page 页码
     * @param size 每页数量
     * @param name 线路名称（模糊查询）
     * @param typeId 线路类型ID
     * @return 线路列表及分页信息
     */
    Result getRouteList(Integer page, Integer size, String name, Integer typeId);

    /**
     * 获取线路详情
     * 根据线路ID获取线路的详细信息
     * @param id 线路ID
     * @return 线路详细信息
     */
    Result getDetail(Integer id);

}