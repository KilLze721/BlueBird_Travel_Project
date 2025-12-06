package com.bird.bluebirdproject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {
    private Integer id; //ID
    private String name; //昵称
    private String token; //令牌
}
