package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.mapper.UserMapper;
import com.bird.bluebirdproject.pojo.vo.LoginVO;
import com.bird.bluebirdproject.pojo.entity.User;
import com.bird.bluebirdproject.service.UserService;
import com.bird.bluebirdproject.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务实现类
 * 实现用户相关的业务逻辑
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录业务实现
     * 验证用户身份，如果验证通过则生成JWT token并返回登录信息
     * @param user 包含用户名和密码的用户对象
     * @return 登录成功返回包含token的登录信息，失败返回null
     */
    @Override
    public LoginVO login(User user) {
        User empLogin = userMapper.getUsernameAndPassword(user);
        if (empLogin != null) {
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id", empLogin.getId());
            dataMap.put("username", empLogin.getUsername());
            String jwt = JwtUtils.generateJwt(dataMap);
            LoginVO login = new LoginVO(empLogin.getId(), empLogin.getName(), jwt);
            return login;
        }
        return null;
    }
}