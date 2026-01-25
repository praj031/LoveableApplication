package com.codingShuttle.loveable.loveable.dto.chat;

import com.codingShuttle.loveable.loveable.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
