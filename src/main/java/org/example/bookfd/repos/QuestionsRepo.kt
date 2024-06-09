package org.example.bookfd.repos;

import org.example.bookfd.domain.Questions;
import org.example.bookfd.domain.TestsNames;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionsRepo extends CrudRepository<Questions,Integer> {
    Questions findById(int id);
    List<Questions> findByTestid (int testid);
}
