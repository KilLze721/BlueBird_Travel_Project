package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.mapper.UserMapper;
import com.bird.bluebirdproject.pojo.LoginInfo;
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
    public LoginInfo login(User user) {
        User empLogin = userMapper.getUsernameAndPassword(user);
        if(empLogin != null){
            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), null);
            return loginInfo;
        }
        //jwt令牌以后再说
//        if (empLogin != null) {
//            Map<String,Object> dataMap = new HashMap<>();
//            dataMap.put("id", empLogin.getId());
//            dataMap.put("username", empLogin.getUsername());
//            String jwt = JwtUtils.generateJwt(dataMap);
//            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), jwt);
//            return loginInfo;
//        }

        return null;
    }
}
