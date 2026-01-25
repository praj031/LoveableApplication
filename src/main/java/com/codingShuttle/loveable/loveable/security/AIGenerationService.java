package com.codingShuttle.loveable.loveable.security;


import reactor.core.publisher.Flux;


public interface AIGenerationService {

    Flux<String> streamResponse(String message, Long projectId);

}
