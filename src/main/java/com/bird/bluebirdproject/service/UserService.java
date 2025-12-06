package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.pojo.Login;
import com.bird.bluebirdproject.pojo.User;

public interface UserService {
    /**
     * 登录
     */
    Login login(User user);
}
