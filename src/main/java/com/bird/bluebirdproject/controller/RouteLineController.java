package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.service.RouteLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteLineController {
    @Autowired
    private RouteLineService routeLineService;

    /**
     * 线路分页 + 筛选
     */
    @GetMapping("/lines")
    public Result list(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer typeId) {

        return routeLineService.getRouteList(page, size, name, typeId);
    }
}
