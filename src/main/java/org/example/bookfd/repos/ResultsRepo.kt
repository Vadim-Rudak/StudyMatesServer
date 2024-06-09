package org.example.bookfd.repos;

import org.example.bookfd.domain.Results;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultsRepo extends CrudRepository<Results,Integer> {
    List<Results> findByIdtest(int id_test);
}
