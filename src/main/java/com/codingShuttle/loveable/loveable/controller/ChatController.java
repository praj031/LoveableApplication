package com.codingShuttle.loveable.loveable.controller;

import com.codingShuttle.loveable.loveable.dto.chat.ChatRequest;
import com.codingShuttle.loveable.loveable.dto.chat.ChatResponse;
import com.codingShuttle.loveable.loveable.dto.chat.StreamResponse;
import com.codingShuttle.loveable.loveable.service.AIGenerationService;
import com.codingShuttle.loveable.loveable.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/chat")
public class ChatController {

    private final AIGenerationService aiGenerationService;
    private final ChatService chatService;

    //To generate a text stream. //Server will send a stream of data rather than sending single data.
    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<StreamResponse>> streamChat(
            @RequestBody ChatRequest request) {

        return aiGenerationService.streamResponse(request.message(), request.projectId())
                .map(data -> ServerSentEvent.<StreamResponse>builder()
                        .data(data)
                        .build());
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<ChatResponse>> getChatHistory(
            @PathVariable Long projectId) {

        return ResponseEntity.ok(chatService.getProjectChatHistory(projectId));
    }

}


