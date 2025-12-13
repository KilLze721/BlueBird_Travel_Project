package com.bird.bluebirdproject.websocket.config;

import com.bird.bluebirdproject.websocket.handler.ChatWebSocketHandler;
import com.bird.bluebirdproject.websocket.interceptor.WsAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket 配置类
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private ChatWebSocketHandler chatWebSocketHandler;

    @Autowired
    private WsAuthInterceptor wsAuthInterceptor;

    /**
     * 注册 WebSocket 处理器
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatWebSocketHandler, "/ws/chat")
                .addInterceptors(wsAuthInterceptor)
                .setAllowedOrigins("*");
    }
}
