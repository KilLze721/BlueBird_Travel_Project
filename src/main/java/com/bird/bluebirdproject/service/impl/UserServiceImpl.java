package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.mapper.UserMapper;
import com.bird.bluebirdproject.pojo.Login;
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
    public Login login(User user) {
        User empLogin = userMapper.getUsernameAndPassword(user);
        if (empLogin != null) {
            Map<String,Object> dataMap = new HashMap<>();
            dataMap.put("id", empLogin.getId());
            dataMap.put("username", empLogin.getUsername());
            String jwt = JwtUtils.generateJwt(dataMap);
            Login login = new Login(empLogin.getId(), empLogin.getName(), jwt);
            return login;
        }
        return null;
    }
}
