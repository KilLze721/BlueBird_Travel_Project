package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.pojo.LoginInfo;
import com.bird.bluebirdproject.pojo.User;

public interface UserService {
    /**
     * 登录
     */
    LoginInfo login(User user);
}
