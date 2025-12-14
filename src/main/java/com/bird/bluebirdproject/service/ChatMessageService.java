package com.bird.bluebirdproject.service;

import com.bird.bluebirdproject.pojo.entity.ChatMessage;
import com.bird.bluebirdproject.websocket.model.ChatMessageWs;

import java.util.List;

/**
 * 聊天消息服务接口
 * @author lenovo
 */
public interface ChatMessageService {

    /**
     * 保存聊天消息
     * @param chat 聊天消息
     */
    void saveMessage(ChatMessageWs chat);

    /**
     * 获取聊天记录
     * @param targetUserId
     * @return
     */
    List<ChatMessage> getHistory(Integer targetUserId);
}
