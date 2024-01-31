package org.example.bookfd.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MenuController {

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
