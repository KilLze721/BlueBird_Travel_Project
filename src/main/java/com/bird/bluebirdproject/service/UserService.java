package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.vo.LoginVO;
import com.bird.bluebirdproject.pojo.User;

public interface UserService {
    /**
     * 登录
     */
    LoginVO login(User user);
}
