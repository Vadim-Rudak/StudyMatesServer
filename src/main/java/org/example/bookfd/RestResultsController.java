package org.example.bookfd;

import org.example.bookfd.domain.Results;
import org.example.bookfd.domain.TestsNames;
import org.example.bookfd.repos.ResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResultsController {

    @Autowired
    private ResultsRepo resultsRepo;

    @PostMapping("/add_result")
    public ResponseEntity<?> create(@RequestBody Results results)
    {
        System.out.println(results.getUsername());
        resultsRepo.save(results);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
