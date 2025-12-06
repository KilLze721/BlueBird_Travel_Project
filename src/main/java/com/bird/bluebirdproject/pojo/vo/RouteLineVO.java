package com.bird.bluebirdproject.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteLineVO {
    private Integer id;
    private String name;
    private Double price;
    private String level;
    private String image;
    private String typeName;
}
