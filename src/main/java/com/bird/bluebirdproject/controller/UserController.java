package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.pojo.vo.LoginVO;
import com.bird.bluebirdproject.pojo.entity.User;
import com.bird.bluebirdproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器类
 * 处理用户相关的HTTP请求，包括用户登录等功能
 */
@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     * 根据用户名和密码进行身份验证，成功后返回包含token的登录信息
     * @param user 包含用户名和密码的用户对象
     * @return 登录成功返回包含token的Result对象，失败返回错误信息
     */
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        LoginVO login = userService.login(user);
        if(login != null){
            return Result.success(login);
        }
        return Result.error("用户名或密码错误");
    }
}