package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.RouteLine;
import com.bird.bluebirdproject.vo.RouteLineVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteLineMapper {
    List<RouteLineVO> selectList(String name, Integer typeId);

    RouteLine selectById(Integer id);
}
