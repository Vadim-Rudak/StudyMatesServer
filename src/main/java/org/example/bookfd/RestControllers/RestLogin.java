package org.example.bookfd.RestControllers;

import org.example.bookfd.domain.Authoriz;
import org.example.bookfd.domain.Reg;
import org.example.bookfd.domain.Role;
import org.example.bookfd.domain.User;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class RestLogin {


    @GetMapping(value = "/authoriz",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addUserInClient(Authentication authentication){
        if (authentication != null){
            String role = authentication.getAuthorities().toString();
            return new Authoriz(authentication.getName(),true,"Авторизация прошла успешно",role.substring(1,role.length()-1));
        }else{
            return new Authoriz("",false,"Ошибка, не верный логин либо пароль","");
        }
    }
}
