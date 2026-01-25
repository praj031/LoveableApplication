package com.codingShuttle.loveable.loveable.service;


import com.codingShuttle.loveable.loveable.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);
}
