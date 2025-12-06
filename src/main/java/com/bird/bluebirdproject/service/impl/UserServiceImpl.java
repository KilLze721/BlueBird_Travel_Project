package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.mapper.UserMapper;
import com.bird.bluebirdproject.vo.LoginVO;
import com.bird.bluebirdproject.pojo.User;
import com.bird.bluebirdproject.service.UserService;
import com.bird.bluebirdproject.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginVO login(User user) {
        User empLogin = userMapper.getUsernameAndPassword(user);
        if (empLogin != null) {
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id", empLogin.getId());
            dataMap.put("username", empLogin.getUsername());
            String jwt = JwtUtils.generateJwt(dataMap);
            LoginVO loginVo = new LoginVO(empLogin.getId(), empLogin.getName(), jwt);
            return loginVo;
        }
        return null;
    }
}
