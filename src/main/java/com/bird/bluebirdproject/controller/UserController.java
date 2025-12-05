package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.pojo.LoginInfo;
import com.bird.bluebirdproject.pojo.User;
import com.bird.bluebirdproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录 , {}", user);
        LoginInfo loginInfo = userService.login(user);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }

}