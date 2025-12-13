package com.bird.bluebirdproject.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 聊天消息类
 * @author lenovo
 */
@Data
public class ChatMessage {
    private Integer id;
    private Integer fromUserId;
    private Integer toUserId;
    private String content;
    private LocalDateTime createTime;
    private Integer status;
}
