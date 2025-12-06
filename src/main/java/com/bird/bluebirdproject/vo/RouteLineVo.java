package com.bird.bluebirdproject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteLineVo {
    private Integer id;
    private String name;
    private Double price;
    private String level;
    private String image;
    private String typeName;
}
