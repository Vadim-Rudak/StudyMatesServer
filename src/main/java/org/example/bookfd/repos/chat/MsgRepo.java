package org.example.bookfd.repos.chat;

import org.example.bookfd.domain.chat.Msg;
import org.springframework.data.repository.CrudRepository;

public interface MsgRepo extends CrudRepository<Msg,Integer> {
}
