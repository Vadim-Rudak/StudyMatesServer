package org.example.bookfd.repos;

import org.example.bookfd.domain.Books;
import org.example.bookfd.domain.TestsNames;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepo extends CrudRepository<Books,Integer> {
    List<Books> findByNumclassAndNamebook(int num_class,String name_book);
    Books findByNamebookAndNumclass(String name_book,int num_class);
    Books findByID(Integer ID);
    Books findByIdbook(int idbook);
}
