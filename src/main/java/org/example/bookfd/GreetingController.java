package org.example.bookfd;


import org.example.bookfd.domain.Message;
import org.example.bookfd.domain.User;
import org.example.bookfd.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo MessageRepo;

    @GetMapping("/")
    public String start(Map<String, Object> model, Authentication authentication) {
        model.put("userstatus",authentication.getAuthorities());
        return "StartPage";
    }

    @GetMapping("/menu")
    public String menu(Map<String, Object> model){

        return "menu";
    }

}