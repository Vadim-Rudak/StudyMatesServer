package org.example.bookfd.controllers;

import org.example.bookfd.domain.Auth;
import org.example.bookfd.domain.Role;
import org.example.bookfd.repos.AuthRepo;
import org.example.bookfd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthRepo authRepo;

    @GetMapping("/reg")
    public String registration(){
        return "reg";
    }
    @PostMapping("/reg")
    public String addUser(Auth auth, Map<String, Object> model){
        if (auth.getLogin().equals("")|| auth.getPassword().equals("")){
            model.put("ErrorName","Заполните поля");
            return "reg";
        }else{
            Auth auth2 = authRepo.findByLogin(auth.getLogin());
            if (auth2 !=null){
                model.put("ErrorName","Пользователь с таким именем уже зарегистрирован");
                return "reg";
            }else {
                auth.setActive(true);
                auth.setRole(Collections.singleton(Role.USER).toString());
                authRepo.save(auth);
                return "redirect:/login";
            }
        }
    }

}
