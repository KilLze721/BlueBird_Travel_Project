package com.bird.bluebirdproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private Integer id; //ID
    private String name; //昵称
    private String token; //令牌
}
