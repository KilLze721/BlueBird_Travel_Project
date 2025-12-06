package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.vo.RouteLineVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RouteLineMapper {
    List<RouteLineVo> selectList(String name, Integer typeId);

}
