package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.pojo.Login;
import com.bird.bluebirdproject.pojo.User;
import com.bird.bluebirdproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        log.info("用户登录 , {}", user);
        Login login = userService.login(user);
        if(login != null){
            return Result.success(login);
        }
        return Result.error("用户名或密码错误");
    }

}