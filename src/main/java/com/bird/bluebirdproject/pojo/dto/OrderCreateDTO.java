package com.bird.bluebirdproject.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO {
    private Integer lineId;
    private String playDate;
    private Integer quantity;
}
