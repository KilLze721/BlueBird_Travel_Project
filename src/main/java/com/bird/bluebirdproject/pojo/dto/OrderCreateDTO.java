package com.bird.bluebirdproject.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单创建数据传输对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO {
    private Integer lineId;
    private String playDate;
    private Integer quantity;
}
