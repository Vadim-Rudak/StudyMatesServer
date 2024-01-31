package org.example.bookfd.restControllers;

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

import java.util.List;

@RestController
public class ListTestController {

    @Autowired
    private TestsNamesRepo TestsNamesRepo;

    @Autowired
    private QuestionsRepo questionsRepo;

    private int Id_Question;


    //(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    @RequestMapping(value = "/ListTestsNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms2(@RequestParam(name="subject", required=false, defaultValue="физика") String subject, Model model) {
        Iterable<TestsNames> ts = TestsNamesRepo.findBySubject(subject);
        return ts;
    }

    @PostMapping("/addquestion")
    public ResponseEntity<?> create(@RequestBody List<Questions> listQuestions)
    {
        System.out.println(listQuestions.size());
        for(int i=0;i<listQuestions.size();i++){
            listQuestions.get(i).setTestid(Id_Question);
            questionsRepo.save(listQuestions.get(i));
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/addtest")
    public ResponseEntity<?> create(@RequestBody TestsNames testsNames)
    {

        TestsNamesRepo.save(testsNames);
        Id_Question = testsNames.getId();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
