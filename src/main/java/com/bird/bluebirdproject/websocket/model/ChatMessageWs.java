package com.bird.bluebirdproject.websocket.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 聊天消息通讯类
 * @author lenovo
 */
@Data
public class ChatMessageWs {
    private Integer fromUserId;
    private Integer toUserId;
    private String content;
    private LocalDateTime time;
}
