package org.example.bookfd;

import org.example.bookfd.domain.AllNamesBooks;
import org.example.bookfd.domain.Message;
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
import java.util.Map;

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
//        Message ms = new Message();
//        ms.setId(54);
//        ms.setText("gygygndj2");
//        ms.setTag("gygyg");
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

//        questions.setTestid(Id_Question);
//        questionsRepo.save(questions);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/addtest")
    public ResponseEntity<?> create(@RequestBody TestsNames testsNames)
    {
//        int d = allNamesBooks.getId();
        System.out.println(testsNames.getSubject());

        TestsNamesRepo.save(testsNames);
        Id_Question = testsNames.getId();

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
