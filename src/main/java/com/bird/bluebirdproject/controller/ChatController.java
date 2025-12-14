package com.bird.bluebirdproject.controller;

import com.bird.bluebirdproject.common.Result;
import com.bird.bluebirdproject.config.UserContext;
import com.bird.bluebirdproject.pojo.entity.ChatMessage;
import com.bird.bluebirdproject.service.ChatMessageService;
import com.bird.bluebirdproject.websocket.model.ChatMessageWs;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "聊天接口")
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatMessageService chatMessageService;

    @Operation(summary = "查找历史聊天记录")
    @GetMapping("/history/{targetUserId}")
    public Result<List<ChatMessage>> history(@PathVariable Integer targetUserId){
        return Result.success(chatMessageService.getHistory(targetUserId));
    }
}
