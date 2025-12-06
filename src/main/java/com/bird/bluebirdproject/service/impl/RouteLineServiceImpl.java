package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.mapper.RouteLineMapper;
import com.bird.bluebirdproject.pojo.RouteLine;
import com.bird.bluebirdproject.service.RouteLineService;
import com.bird.bluebirdproject.pojo.vo.RouteLineVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RouteLineServiceImpl implements RouteLineService {
    @Autowired
    private RouteLineMapper routeLineMapper;

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

    @Override
    public Result getDetail(Integer id) {
        RouteLine route = routeLineMapper.selectById(id);
        if (route == null) {
            return Result.error("线路不存在");
        }
        return Result.success(route);
    }


}
