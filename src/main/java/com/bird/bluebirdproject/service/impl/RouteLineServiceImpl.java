package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.mapper.RouteLineMapper;
import com.bird.bluebirdproject.pojo.entity.RouteLine;
import com.bird.bluebirdproject.service.RouteLineService;
import com.bird.bluebirdproject.pojo.vo.RouteLineVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 旅游线路服务实现类
 * 实现旅游线路相关的业务逻辑
 */
@Service
public class RouteLineServiceImpl implements RouteLineService {
    @Autowired
    private RouteLineMapper routeLineMapper;

    /**
     * 获取线路列表业务实现
     * 使用PageHelper实现分页功能，支持按线路名称和类型ID进行筛选
     * @param page 页码
     * @param size 每页数量
     * @param name 线路名称（模糊查询）
     * @param typeId 线路类型ID
     * @return 线路列表及分页信息
     */
    @Override
    public Result getRouteList(Integer page, Integer size, String name, Integer typeId) {
        // PageHelper 分页
        PageHelper.startPage(page, size);
        // 查询数据
        List<RouteLineVO> list = routeLineMapper.selectList(name, typeId);
        // PageInfo 包装分页信息
        PageInfo<RouteLineVO> pageInfo = new PageInfo<>(list);
        // 返回数据结构
        Map<String, Object> data = new HashMap<>();
        data.put("total", pageInfo.getTotal());
        data.put("list", pageInfo.getList());

        return Result.success(data);
    }

    /**
     * 获取线路详情业务实现
     * 根据线路ID获取线路的详细信息
     * @param id 线路ID
     * @return 线路详细信息
     */
    @Override
    public Result getDetail(Integer id) {
        RouteLine route = routeLineMapper.selectById(id);
        if (route == null) {
            return Result.error("线路不存在");
        }
        return Result.success(route);
    }


}