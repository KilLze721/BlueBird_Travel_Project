package com.bird.bluebirdproject.service.impl;

import com.bird.bluebirdproject.config.UserContext;
import com.bird.bluebirdproject.mapper.ChatMessageMapper;
import com.bird.bluebirdproject.pojo.entity.ChatMessage;
import com.bird.bluebirdproject.service.ChatMessageService;
import com.bird.bluebirdproject.websocket.model.ChatMessageWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageMapper chatMessageMapper;

    /**
     * 保存聊天消息到数据库
     * @param wsMsg WebSocket接收到的聊天消息对象
     */
    @Override
    public void saveMessage(ChatMessageWs wsMsg) {
        // 转换WebSocket消息对象为数据库实体对象
        ChatMessage entity = new ChatMessage();
        // 从用户上下文获取用户ID(发送人ID)
        Integer userId = UserContext.getUserId();
        entity.setFromUserId(userId);
        entity.setToUserId(wsMsg.getToUserId());
        entity.setContent(wsMsg.getContent());
        entity.setCreateTime(wsMsg.getTime());
        entity.setStatus(0);
        chatMessageMapper.insert(entity);
    }

    /**
     * 获取聊天记录
     * @param targetUserId
     * @return
     */
    @Override
    public List<ChatMessage> getHistory(Integer targetUserId) {
        Integer userId = UserContext.getUserId();
        if (userId == null) {
            throw new RuntimeException("未登录");
        }
        return chatMessageMapper.selectHistory(userId, targetUserId);
    }
}
