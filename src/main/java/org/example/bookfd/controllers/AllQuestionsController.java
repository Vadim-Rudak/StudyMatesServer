package org.example.bookfd.controllers;

import org.example.bookfd.domain.Questions;
import org.example.bookfd.domain.TestsNames;
import org.example.bookfd.repos.QuestionsRepo;
import org.example.bookfd.repos.TestsNamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class AllQuestionsController {

    @Autowired
    private QuestionsRepo questionsRepo;

    @Autowired
    private TestsNamesRepo TestsNamesRepo;

    @RequestMapping("/Quest")
    public String greeting1(@RequestParam(name="id_test", required=false, defaultValue="-1") int id_test,
                            @RequestParam(name="name_sub", required=false, defaultValue="-1") String name_sub,
                            @RequestParam(name="num_class", required=false, defaultValue="-1") int num_class,Map<String, Object> model) throws UnsupportedEncodingException {


        if (id_test!=-1){
            Iterable<Questions> questions = questionsRepo.findByTestid(id_test);
            model.put("questions", questions);
        }
        Iterable<TestsNames> tests = TestsNamesRepo.findBySubjectAndNumclass(decodeString(name_sub),num_class);
        model.put("tests", tests);
        model.put("Id_test",id_test);
        model.put("name_sub",name_sub);
        model.put("num_c",num_class);
        return "ts";
    }

    @GetMapping("/DeleteQuestion")
    public String DeleteQuestion(@RequestParam(name="name_sub", required=false, defaultValue="0YTQuNC30LjQutCw") String name_sub,
                        @RequestParam(name="num_class", required=false, defaultValue="") int num_class,
                       @RequestParam(name="id_test", required=false, defaultValue="") int id_test,
                       @RequestParam(name="del_ques_id", required=false, defaultValue="-1") int del_id, Map<String, Object> model) {
        try {
            String name_s = decodeString(name_sub);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        questionsRepo.deleteById(del_id);
        TestsNames testsNames = TestsNamesRepo.findById(id_test);
        testsNames.setNumquestions(questionsRepo.findByTestid(id_test).size());
        TestsNamesRepo.save(testsNames);

        return "redirect:/Quest?name_sub="+name_sub+"&num_class="+num_class+"&id_test="+id_test;
    }


    @RequestMapping("/UpdateQuestion")
    public String UpdateQuestion(@ModelAttribute("question1") Questions question) {

        TestsNames testsNames = TestsNamesRepo.findById(question.getTestid());
        questionsRepo.save(question);

        String name_s = null;
        try {
            name_s = encodeString(testsNames.getSubject());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "redirect:/Quest?name_sub="+name_s+"&num_class="+testsNames.getNumclass()+"&id_test="+testsNames.getId();
    }

    @GetMapping("/add_quest")
    public String addquest(@RequestParam(name="id_test", required=false, defaultValue="-1") int id_test, Map<String, Object> model){
        TestsNames testsNames = TestsNamesRepo.findById(id_test);
        model.put("name_test",testsNames.getNametest());
        model.put("testid", id_test);
        return "AddQuestion";
    }

    @RequestMapping("/AddQuestion")
    public String AddQuestion(@RequestParam(name="testid", required=false, defaultValue="-1") int id_test,@ModelAttribute("question1") Questions question) {
        TestsNames ts = TestsNamesRepo.findById(id_test);
        ts.setNumquestions(ts.getNumquestions()+1);
        TestsNamesRepo.save(ts);
        TestsNames testsNames = TestsNamesRepo.findById(question.getTestid());
        questionsRepo.save(question);
        String name_s = null;
        try {
            name_s = encodeString(testsNames.getSubject());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:/Quest?name_sub="+name_s+"&num_class="+testsNames.getNumclass()+"&id_test="+testsNames.getId();
    }

    @GetMapping("/up_quest")
    public String upquest(@RequestParam(name="id_test", required=false, defaultValue="-1") int id_test, Map<String, Object> model){
        TestsNames testsNames = TestsNamesRepo.findById(id_test);
        model.put("testsNames",testsNames);
        return "EditInfoTest";
    }

    @GetMapping("/add_test")
    public String addtest(Map<String, Object> model){
        return "AddTest";
    }

    @RequestMapping("/AddTest")
    public String AddTest(@Valid @ModelAttribute("test1") TestsNames testName, BindingResult bindingResult, Map<String, Object> model) {

        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
            model.put("testName",testName);
            model.put("nametestError",errorsMap.get("nametestError"));
            model.put("subjectError",errorsMap.get("subjectError"));
            model.put("numclassError",errorsMap.get("numclassError"));
            return "/AddTest";
        }else {
            TestsNamesRepo.save(testName);
            String name_s = null;
            try {
                name_s = encodeString(testName.getSubject());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "redirect:/Tests?name_sub="+name_s+"&num_class="+testName.getNumclass();
        }
    }

    @RequestMapping("/EditTest")
    public String AddQuestion(@Valid @ModelAttribute("Up_ts") TestsNames testName, BindingResult bindingResult, Map<String, Object> model) {

        if (bindingResult.hasErrors()){
            Map<String, String> errorsMap = getErrorsMap(bindingResult);
            model.put("testsNames",testName);
            model.put("nametestError",errorsMap.get("nametestError"));
            model.put("subjectError",errorsMap.get("subjectError"));
            model.put("numclassError",errorsMap.get("numclassError"));
            return "EditInfoTest2";
        }else {
            TestsNamesRepo.save(testName);
            String name_s = null;
            try {
                name_s = encodeString(testName.getSubject());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "redirect:/Quest?name_sub="+name_s+"&num_class="+testName.getNumclass()+"&id_test="+testName.getId();
        }
    }


    @GetMapping("/DeleteTest")
    public String DeleteTest(@RequestParam(name="name_sub", required=false, defaultValue="0YTQuNC30LjQutCw") String name_sub,
                                 @RequestParam(name="num_class", required=false, defaultValue="") int num_class,
                                 @RequestParam(name="id_test", required=false, defaultValue="") int id_test, Map<String, Object> model) {

        TestsNamesRepo.deleteById(id_test);

        return "redirect:/Tests?name_sub="+name_sub+"&num_class="+num_class;
    }


    public static String encodeString(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("UTF-8");
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }

    private Map<String, String> getErrorsMap(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        Map<String, String> errorsMap = bindingResult.getFieldErrors().stream().collect(collector);
        return errorsMap;
    }

    // Decode
    public static String decodeString(String encodeText) throws UnsupportedEncodingException {
        byte[] decoded = Base64.getMimeDecoder().decode(encodeText);
        String output = new String(decoded);
        return output;
    }

}
