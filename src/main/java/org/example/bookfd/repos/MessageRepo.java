package org.example.bookfd.repos;

import org.example.bookfd.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTagAndId(String tag, int id);

}

