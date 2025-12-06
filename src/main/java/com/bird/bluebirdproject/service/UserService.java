package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.pojo.vo.LoginVO;
import com.bird.bluebirdproject.pojo.entity.User;

/**
 * 用户服务接口
 * 定义用户相关的业务逻辑接口
 */
public interface UserService {
    /**
     * 用户登录业务逻辑
     * 验证用户身份并生成登录信息（包含token）
     * @param user 包含用户名和密码的用户对象
     * @return 登录成功返回包含token的登录信息，失败返回null
     */
    LoginVO login(User user);
}