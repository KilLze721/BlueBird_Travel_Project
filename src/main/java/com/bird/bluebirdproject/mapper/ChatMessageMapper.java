package com.bird.bluebirdproject.mapper;

import com.bird.bluebirdproject.pojo.entity.ChatMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    /**
     * 插入聊天消息
     * @param message
     * @return
     */
    int insert(ChatMessage message);

    /**
     * 查询聊天记录
     * @param userId
     * @param targetId
     * @return
     */
    List<ChatMessage> selectHistory(@Param("userId") Integer userId, @Param("targetId") Integer targetId);
}
