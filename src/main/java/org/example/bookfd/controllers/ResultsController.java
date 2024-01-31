package org.example.bookfd.controllers;

import org.example.bookfd.domain.TestsNames;
import org.example.bookfd.repos.ResultsRepo;
import org.example.bookfd.repos.TestsNamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

@Controller
public class ResultsController {

    @Autowired
    private ResultsRepo resultsRepo;

    @Autowired
    private TestsNamesRepo testsNamesRepo;

    @GetMapping("/Results")
    public String res(@RequestParam(name="name_sub", required=false, defaultValue="Физика") String name_sub, Map<String, Object> model){
        String name_s = null;
        try {
            name_s = decodeString(name_sub);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.put("tests1",testsNamesRepo.findBySubjectAndNumclass(name_s,1));
        model.put("tests2",testsNamesRepo.findBySubjectAndNumclass(name_s,2));
        model.put("tests3",testsNamesRepo.findBySubjectAndNumclass(name_s,3));
        model.put("tests4",testsNamesRepo.findBySubjectAndNumclass(name_s,4));
        model.put("tests5",testsNamesRepo.findBySubjectAndNumclass(name_s,5));
        model.put("tests6",testsNamesRepo.findBySubjectAndNumclass(name_s,6));
        model.put("tests7",testsNamesRepo.findBySubjectAndNumclass(name_s,7));
        model.put("tests8",testsNamesRepo.findBySubjectAndNumclass(name_s,8));
        model.put("tests9",testsNamesRepo.findBySubjectAndNumclass(name_s,9));
        model.put("tests10",testsNamesRepo.findBySubjectAndNumclass(name_s,10));
        model.put("tests11",testsNamesRepo.findBySubjectAndNumclass(name_s,11));
        model.put("sub",name_sub);
        return "Results";
    }

    @GetMapping("/ResultsTable")
    public String restables(@RequestParam(name="name_sub", required=false, defaultValue="Физика") String name_sub,
                            @RequestParam(name="id_test", required=false, defaultValue="") int id_test,
                            Map<String, Object> model){
        String name_s = null;
        try {
            name_s = decodeString(name_sub);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        TestsNames testsNames = testsNamesRepo.findById(id_test);
        model.put("tests1",testsNamesRepo.findBySubjectAndNumclass(name_s,1));
        model.put("tests2",testsNamesRepo.findBySubjectAndNumclass(name_s,2));
        model.put("tests3",testsNamesRepo.findBySubjectAndNumclass(name_s,3));
        model.put("tests4",testsNamesRepo.findBySubjectAndNumclass(name_s,4));
        model.put("tests5",testsNamesRepo.findBySubjectAndNumclass(name_s,5));
        model.put("tests6",testsNamesRepo.findBySubjectAndNumclass(name_s,6));
        model.put("tests7",testsNamesRepo.findBySubjectAndNumclass(name_s,7));
        model.put("tests8",testsNamesRepo.findBySubjectAndNumclass(name_s,8));
        model.put("tests9",testsNamesRepo.findBySubjectAndNumclass(name_s,9));
        model.put("tests10",testsNamesRepo.findBySubjectAndNumclass(name_s,10));
        model.put("tests11",testsNamesRepo.findBySubjectAndNumclass(name_s,11));
        model.put("TableInfo",resultsRepo.findByIdtest(id_test));
        model.put("sub",name_sub);
        model.put("namets",testsNames.getNametest());
        return "ResultsTable";
    }

    public static String decodeString(String encodeText) throws UnsupportedEncodingException {
        byte[] decoded = Base64.getMimeDecoder().decode(encodeText);
        String output = new String(decoded);
        return output;
    }
}
