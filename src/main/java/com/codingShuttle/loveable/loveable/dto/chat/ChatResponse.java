package com.codingShuttle.loveable.loveable.dto.chat;

import com.codingShuttle.loveable.loveable.entity.ChatEvent;
import com.codingShuttle.loveable.loveable.entity.ChatSession;
import com.codingShuttle.loveable.loveable.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        //ChatSession chatSession,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt

) {
}
