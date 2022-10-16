package org.example.bookfd;

import org.example.bookfd.domain.Reg;
import org.example.bookfd.domain.Role;
import org.example.bookfd.domain.User;
import org.example.bookfd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/reg")
    public String registration(){
        return "reg";
    }
    @PostMapping("/reg")
    public String addUser(User user, Map<String, Object> model){
        if (user.getLogin().equals("")||user.getPassword().equals("")){
            model.put("ErrorName","Заполните поля");
            return "reg";
        }else{
            User userDB = userRepo.findByLogin(user.getLogin());
            if (userDB!=null){
                model.put("ErrorName","Пользователь с таким именем уже зарегистрирован");
                return "reg";
            }else {
                user.setActive(true);
                user.setRoles(Collections.singleton(Role.USER));
                userRepo.save(user);
                return "redirect:/login";
            }
        }
    }

}
