package com.bird.bluebirdproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private Integer id; //ID
    private String name; //昵称
    private String token; //令牌
}
