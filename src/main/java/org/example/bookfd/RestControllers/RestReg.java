package org.example.bookfd.RestControllers;

import org.example.bookfd.domain.Questions;
import org.example.bookfd.domain.Reg;
import org.example.bookfd.domain.Role;
import org.example.bookfd.domain.User;
import org.example.bookfd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class RestReg {

    @Autowired
    private UserRepo userRepo;


    @PostMapping(value = "/reg_mob",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addUserInClient(@RequestBody User user){
        if (user.getLogin().equals("")||user.getPassword().equals("")){
            return new Reg("Заполните поля", false);
        }else{
            User userDB = userRepo.findByLogin(user.getLogin());
            if (userDB!=null){
                return new Reg("Пользователь с таким именем уже зарегистрирован", false);
            }else {
                user.setActive(true);
                user.setRoles(Collections.singleton(Role.USER));
                userRepo.save(user);
                return new Reg("Пользователь успешно зарегистрирован",true);
            }
        }
    }
}
