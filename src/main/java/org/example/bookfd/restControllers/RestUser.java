package org.example.bookfd.restControllers;

import org.example.bookfd.domain.Photo;
import org.example.bookfd.repos.PhotoRepo;
import org.example.bookfd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
public class RestUser {

    @Autowired
    private PhotoRepo photoRepo;

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/Photo", method = RequestMethod.GET, produces = "application/jpeg")
    public ResponseEntity<?> restGetUserPhoto(@RequestParam(name="id", required=false, defaultValue="0") int id_photo, Model model) {
        Photo photo = photoRepo.findById(id_photo);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(Base64.getMimeDecoder().decode(photo.getRes()));
    }

    @PostMapping(value = "/Verification",produces = MediaType.APPLICATION_JSON_VALUE)
    public String restSetVerification(@RequestParam(name="id", required=false, defaultValue="0") int id_user, Model model) {

        Photo photo = photoRepo.findById(id_user);
        photo.setVerification(true);
        photoRepo.save(photo);

        return " ";
    }


    @RequestMapping(value = "/GetAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAllUsers() {
        return userRepo.findAll();
    }

    @RequestMapping(value = "/SelectUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object selectUsers(@RequestParam(name="list", required=false, defaultValue="0") List<Integer> listIds) {

        return userRepo.findByIdIn(listIds);
    }
}
