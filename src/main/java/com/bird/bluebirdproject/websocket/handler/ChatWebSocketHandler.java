package com.bird.bluebirdproject.websocket.handler;

import com.bird.bluebirdproject.websocket.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket处理器类
 */
@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ObjectMapper objectMapper;
    // 在线用户：userId -> session
    private static final Map<Integer, WebSocketSession> ONLINE_USERS = new ConcurrentHashMap<>();

    /**
     * 用户建立连接（上线）
     * @param session
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        Integer userId = (Integer) session.getAttributes().get("userId");
        ONLINE_USERS.put(userId, session);
        System.out.println("用户 " + userId + " 已上线");
    }

    /**
     * 接收并处理消息
     * @param session
     * @param message
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        // 解析消息
        ChatMessage chat = objectMapper.readValue(
                message.getPayload(),
                ChatMessage.class
        );
        // 补充服务器字段
        chat.setTime(LocalDateTime.now());
        // 找到接收方
        WebSocketSession toSession = ONLINE_USERS.get(chat.getToUserId());
        // 消息转发
        if (toSession != null && toSession.isOpen()) {
            toSession.sendMessage(
                    new TextMessage(objectMapper.writeValueAsString(chat))
            );
        }
    }

    /**
     * 用户断开连接（下线）
     * @param session
     * @param status
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        // 下线处理
        Integer userId = (Integer) session.getAttributes().get("userId");
        ONLINE_USERS.remove(userId);
        System.out.println("用户下线：" + userId);
    }
}
