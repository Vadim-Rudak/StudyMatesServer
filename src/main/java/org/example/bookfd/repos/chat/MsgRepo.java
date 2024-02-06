package org.example.bookfd.repos.chat;

import org.example.bookfd.domain.chat.Msg;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MsgRepo extends CrudRepository<Msg,Integer> {
    List<Msg> findBychatidIn(List<Integer> listChatId);
}
