package org.example.bookfd.repos;

import org.example.bookfd.domain.TestsNames;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsNamesRepo extends CrudRepository<TestsNames,Integer> {
    List<TestsNames> findBySubjectAndNumclass(String subject,int numclass);
    List<TestsNames> findBySubject(String subject);
    List<TestsNames> findByNumclass(int numclass);
    TestsNames findByNametest(String name_test);
    TestsNames findById(int id);

}
