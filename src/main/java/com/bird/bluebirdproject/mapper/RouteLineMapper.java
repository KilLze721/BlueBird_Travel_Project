package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.entity.RouteLine;
import com.bird.bluebirdproject.pojo.vo.RouteLineVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteLineMapper {
    /**
     * 查询线路列表
     * @param name 线路名称（模糊查询）
     * @param typeId 线路类型ID
     * @return 线路列表
     */
    List<RouteLineVO> selectList(String name, Integer typeId);

    /**
     * 根据ID查询线路详情
     * @param id 线路ID
     * @return 线路详情
     */
    RouteLine selectById(Integer id);
}
