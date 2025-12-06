package com.bird.bluebirdproject.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer userId;
    private Integer lineId;
    private String playDate;
    private Integer quantity;
    private Double price;
    private String status;
}
