package org.example.bookfd.RestControllers;

import org.example.bookfd.domain.Photo;
import org.example.bookfd.repos.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class RestUser {

    @Autowired
    private PhotoRepo photoRepo;

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
}
