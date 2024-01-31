package org.example.bookfd.restControllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bookfd.domain.*;
import org.example.bookfd.repos.AuthRepo;
import org.example.bookfd.repos.PhotoRepo;
import org.example.bookfd.repos.SchoolRepo;
import org.example.bookfd.repos.UserRepo;
import org.example.bookfd.response.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@RestController
public class RestReg {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private PhotoRepo photoRepo;

    @Autowired
    private SchoolRepo schoolRepo;

    @PostMapping(value = "/registration_mobile",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object registrationInMobile(@RequestParam(name="user", required=false, defaultValue="-1") String userJSON,@RequestParam("user_photo") MultipartFile filePhoto) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserMod userMod = objectMapper.readValue(userJSON, UserMod.class);

        System.out.println(userMod);

        User user = new User();
        user.setName(userMod.getName());
        user.setGender(userMod.getGender());
        user.setCityLive(userMod.getCityLive());
        user.setLastName(userMod.getLastName());
        user.setDateBirthday(userMod.getDateBirthday());
        userRepo.save(user);

        int user_id = user.getId();

        Auth auth = userMod.getAuth();
        auth.setId(user_id);
        authRepo.save(auth);

        Photo photo = userMod.getPhoto();
        photo.setId(user_id);
        photo.setRes(encodeString(filePhoto.getBytes()));
        photoRepo.save(photo);

        School school = userMod.getSchool();
        school.setId(user_id);
        schoolRepo.save(school);

        userMod.setId(user_id);

        return new Registration(true,"Заполните поля",userMod);
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }
}
