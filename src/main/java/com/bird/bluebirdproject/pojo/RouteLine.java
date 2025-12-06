package com.bird.bluebirdproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
