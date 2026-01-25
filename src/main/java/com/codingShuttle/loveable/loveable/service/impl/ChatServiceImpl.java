package com.codingShuttle.loveable.loveable.service.impl;

import com.codingShuttle.loveable.loveable.dto.chat.ChatResponse;
import com.codingShuttle.loveable.loveable.entity.ChatMessage;
import com.codingShuttle.loveable.loveable.entity.ChatSession;
import com.codingShuttle.loveable.loveable.entity.ChatSessionId;
import com.codingShuttle.loveable.loveable.mapper.ChatMapper;
import com.codingShuttle.loveable.loveable.repository.ChatMessageRepository;
import com.codingShuttle.loveable.loveable.repository.ChatSessionRepository;
import com.codingShuttle.loveable.loveable.security.AuthUtil;
import com.codingShuttle.loveable.loveable.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}
