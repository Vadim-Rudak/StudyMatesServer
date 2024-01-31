package org.example.bookfd.restControllers;

import org.example.bookfd.domain.Questions;
import org.example.bookfd.repos.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionsController {

    @Autowired
    private QuestionsRepo questionsRepo;

    @RequestMapping(value = "/Questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms2(@RequestParam(name="test_id", required=false, defaultValue="") Integer test_id, Model model) {
        Iterable<Questions> questions = questionsRepo.findByTestid(test_id);
        return questions;
    }
}
