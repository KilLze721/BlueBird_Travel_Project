package com.bird.bluebirdproject.websocket.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 聊天消息类
 */
@Data
public class ChatMessage {
    private Integer fromUserId;
    private Integer toUserId;
    private String content;
    private LocalDateTime time;
}
