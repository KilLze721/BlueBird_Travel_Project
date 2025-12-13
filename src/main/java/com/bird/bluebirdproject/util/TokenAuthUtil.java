package com.bird.bluebirdproject.util;

import io.jsonwebtoken.Claims;

public class TokenAuthUtil {
    /**
     * 验证token并返回用户ID
     * @param token
     * @return
     */
    public static Integer checkAndGetUserId(String token) {
        // 验证token
        if (token == null || token.isBlank()) {
            throw new RuntimeException("未登录");
        }
        // 解析token
        Claims claims = JwtUtils.parseJWT(token);
        return claims.get("id", Integer.class);
    }
}
