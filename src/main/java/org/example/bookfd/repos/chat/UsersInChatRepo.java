package org.example.bookfd.repos.chat;

import org.example.bookfd.domain.chat.UsersInChat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersInChatRepo extends CrudRepository<UsersInChat,Integer> {
    List<UsersInChat> findByuserid(int userId);
    List<UsersInChat> findBychatidIn(List<Integer> listChatId);
}
