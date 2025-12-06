package com.bird.bluebirdproject.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 线路实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteLine {
    private Integer id;
    private String name;
    private Double price;
    private String level;
    private String image;
    private String descText;
    private Integer typeId;
}
