package com.codingShuttle.loveable.loveable.repository;

import com.codingShuttle.loveable.loveable.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent, Long> {
}
