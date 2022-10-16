package org.example.bookfd.repos;

import org.example.bookfd.domain.AllNamesBooks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AllNamesBooksRepo extends CrudRepository<AllNamesBooks,Integer> {
    List<AllNamesBooks> findByNumclass(int numclass);
    AllNamesBooks findByNumclassAndNamebook(int num,String namebook);
    AllNamesBooks findById(int id);
}
