package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.pojo.dto.OrderCreateDTO;
import com.bird.bluebirdproject.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Result create(@RequestBody OrderCreateDTO dto, HttpServletRequest request) {
        return orderService.create(dto, request);
    }

    @GetMapping("/mycreate")
    public Result myOrders(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return orderService.getMyOrders(page, size);
    }

    @PutMapping("/{id}/cancel")
    public Result cancelOrder(@PathVariable Integer id) {
        return orderService.cancelOrder(id);
    }
}
