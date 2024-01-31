package org.example.bookfd.restControllers;

import org.example.bookfd.domain.AllNamesBooks;
import org.example.bookfd.repos.AllNamesBooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AllNamesBooksController {

    @Autowired
    private AllNamesBooksRepo allNamesBooksRepo;

    @RequestMapping(value = "/AllBooks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object allBooks(Map<String, Object> model) {
        Iterable<AllNamesBooks> booksw = allNamesBooksRepo.findAll();
        return booksw;
    }
}
