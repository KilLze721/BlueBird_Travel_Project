package com.bird.bluebirdproject.interceptor;

import com.bird.bluebirdproject.config.UserContext;
import com.bird.bluebirdproject.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从 header 获取 token
        String token = request.getHeader("token");

        // 支持从 URL 获取 token
        if ((token == null || token.isEmpty()) && request.getParameter("token") != null) {
            token = request.getParameter("token");
        }

        // token 为空则返回 401
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }

        try {
            // 解析 token
            Map<String, Object> claims = JwtUtils.parseJWT(token);
            Integer userId = (Integer) claims.get("id");
            // 保存 userId 到 ThreadLocal
            UserContext.setUserId(userId);
            return true;
        } catch (Exception e) {
            log.error("Token 校验失败: {}", e.getMessage());
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        UserContext.clear();
    }

}