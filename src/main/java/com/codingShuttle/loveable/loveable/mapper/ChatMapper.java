package com.codingShuttle.loveable.loveable.mapper;

import com.codingShuttle.loveable.loveable.dto.chat.ChatResponse;
import com.codingShuttle.loveable.loveable.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
