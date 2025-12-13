package com.bird.bluebirdproject.interceptor;

import com.bird.bluebirdproject.config.UserContext;
import com.bird.bluebirdproject.util.JwtUtils;
import com.bird.bluebirdproject.util.TokenAuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * Token拦截器类
 * 用于拦截请求并验证JWT token的有效性，同时从token中解析用户信息
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行拦截
     * 从请求头或URL参数中获取token，验证其有效性，并将用户ID保存到ThreadLocal中
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @param handler 处理器
     * @return 验证通过返回true，否则返回false
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 header 获取 token
        String token = request.getHeader("token");

        try {
            // 调用TokenAuthUtil类验证和解析token
            Integer userId = TokenAuthUtil.checkAndGetUserId(token);
            // 保存 userId 到 ThreadLocal
            UserContext.setUserId(userId);
            return true;
        } catch (Exception e) {
            log.error("Token 校验失败: {}", e.getMessage());
            response.setStatus(401);
            return false;
        }
    }

    /**
     * 在请求完成之后执行清理工作
     * 清除保存在ThreadLocal中的用户ID，防止内存泄漏
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @param handler 处理器
     * @param ex 异常对象
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.clear();
    }

}