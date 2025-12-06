package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.dto.OrderCreateDTO;
import jakarta.servlet.http.HttpServletRequest;


public interface OrderService {
    Result create(OrderCreateDTO dto, HttpServletRequest request);
}

