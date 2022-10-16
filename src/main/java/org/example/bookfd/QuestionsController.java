package org.example.bookfd;

import org.example.bookfd.domain.Questions;
import org.example.bookfd.domain.TestsNames;
import org.example.bookfd.repos.QuestionsRepo;
import org.example.bookfd.repos.TestsNamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionsController {

    @Autowired
    private QuestionsRepo questionsRepo;
    //(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    @RequestMapping(value = "/Questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms2(@RequestParam(name="test_id", required=false, defaultValue="") Integer test_id, Model model) {
//        Message ms = new Message();
//        ms.setId(54);
//        ms.setText("gygygndj2");
//        ms.setTag("gygyg");
        Iterable<Questions> questions = questionsRepo.findByTestid(test_id);
        return questions;
    }
}
