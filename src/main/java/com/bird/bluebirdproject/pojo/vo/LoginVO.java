package com.bird.bluebirdproject.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    private Integer id;
    private String name;
    private String token;
}
