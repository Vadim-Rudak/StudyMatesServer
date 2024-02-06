package org.example.bookfd.repos.chat;

import org.example.bookfd.domain.chat.Chat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepo extends CrudRepository<Chat,Integer> {
    Chat findByID(Integer id);
}