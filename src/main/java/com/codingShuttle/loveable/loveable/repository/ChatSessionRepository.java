package com.codingShuttle.loveable.loveable.repository;

import com.codingShuttle.loveable.loveable.entity.ChatSession;
import com.codingShuttle.loveable.loveable.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
