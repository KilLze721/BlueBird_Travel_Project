package com.bird.bluebirdproject.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 我的订单列表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderVO {
    private Integer orderId;
    private String lineName;
    private String image;
    private String playDate;
    private Integer quantity;
    private Double price;
    private String status;
}
