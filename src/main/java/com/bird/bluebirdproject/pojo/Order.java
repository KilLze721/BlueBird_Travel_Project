package com.bird.bluebirdproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
