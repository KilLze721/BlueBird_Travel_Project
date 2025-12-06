package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.vo.LoginVo;
import com.bird.bluebirdproject.pojo.User;

public interface UserService {
    /**
     * 登录
     */
    LoginVo login(User user);
}
