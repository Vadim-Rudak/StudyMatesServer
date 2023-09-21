package org.example.bookfd.RestControllers;

import org.example.bookfd.domain.*;
import org.example.bookfd.repos.AuthRepo;
import org.example.bookfd.repos.PhotoRepo;
import org.example.bookfd.repos.SchoolRepo;
import org.example.bookfd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLogin {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private PhotoRepo photoRepo;


    @GetMapping(value = "/authoriz",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addUserInClient(Authentication authentication){
        if (authentication != null){
            UserMod userMod = new UserMod();
            Auth auth = authRepo.findByLogin(authentication.getName());
            int user_id = auth.getId();
            User user = userRepo.findById(user_id);
            School school = schoolRepo.findById(user_id);
            Photo photo = photoRepo.findById(user_id);
            photo.setRes(null);

            userMod.setUser(user);
            userMod.setAuth(auth);
            userMod.setSchool(school);
            userMod.setPhoto(photo);

            return new Authoriz(true,"Авторизация прошла успешно",userMod);
        }else{
            return new Authoriz(false,"Ошибка, не верный логин либо пароль",null);
        }
    }
}
