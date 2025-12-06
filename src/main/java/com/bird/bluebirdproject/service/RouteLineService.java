package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.common.Result;

public interface RouteLineService {
    Result getRouteList(Integer page, Integer size, String name, Integer typeId);
}
