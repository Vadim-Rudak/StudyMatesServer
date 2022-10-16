package org.example.bookfd;

import org.example.bookfd.domain.Message;
import org.example.bookfd.domain.TestsNames;
import org.example.bookfd.repos.TestsNamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

@Controller
public class TestsController {

    @Autowired
    private TestsNamesRepo TestsNamesRepo;

    @RequestMapping("/Tests")
    public String greeting1(@RequestParam(name="name_sub", required=false, defaultValue="Физика") String name_sub,@RequestParam(name="num_class", required=false, defaultValue="11") int num_class, Map<String, Object> model) {
        String name_s = null;
        try {
            name_s = decodeString(name_sub);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Iterable<TestsNames> tests = TestsNamesRepo.findBySubjectAndNumclass(name_s,num_class);
        model.put("tests", tests);
        model.put("name_sub", name_sub);
        return "Tests";
    }

    @GetMapping("/menu_sub")
    public String menu_sub(Map<String, Object> model) {
        return "MenuSubjects";
    }

    @GetMapping("/menu_sub_res")
    public String menu_sub2(Map<String, Object> model) {
        return "MenuSubjects2";
    }

    public static String encodeString(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("UTF-8");
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }

    // Decode
    public static String decodeString(String encodeText) throws UnsupportedEncodingException {
        byte[] decoded = Base64.getMimeDecoder().decode(encodeText);
        String output = new String(decoded);
        return output;
    }
}
