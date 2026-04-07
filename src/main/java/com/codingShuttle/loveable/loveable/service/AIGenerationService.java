package com.codingShuttle.loveable.loveable.service;


import com.codingShuttle.loveable.loveable.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;


public interface AIGenerationService {

    Flux<StreamResponse> streamResponse(String message, Long projectId);

}
