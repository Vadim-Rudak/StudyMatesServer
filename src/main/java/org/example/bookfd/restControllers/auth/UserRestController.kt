package org.example.bookfd.restControllers.auth

import org.example.bookfd.repos.PhotoRepo
import org.example.bookfd.repos.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UserRestController @Autowired constructor(
    private val photoRepo: PhotoRepo,
    private val userRepo: UserRepo
) {

    private fun decodeString(encodeText: String?) = String(Base64.getMimeDecoder().decode(encodeText))

    /*
        Get user photo by id
    */
    @RequestMapping(value = ["/Photo"], method = [RequestMethod.GET], produces = ["application/jpeg"])
    fun getUserPhoto(@RequestParam(name="id", required=false, defaultValue="0") photoId:Int) = ResponseEntity.ok()
        .contentType(MediaType.IMAGE_JPEG)
        .body(decodeString(photoRepo.findById(photoId)?.res))

    /*
        Set verification status
    */
    @PostMapping(value = ["/Verification"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun verification(@RequestParam(name="id", required=false, defaultValue="0") userId:Int){
        photoRepo.findById(userId)?.apply {
            verification = true
        }.also {
            photoRepo.save(it)
        }
    }

    /*
        Get list all users
    */
    @RequestMapping(value = ["/GetAllUsers"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getListAllUsers() = userRepo.findAll()

    /*
        Get list selected users
    */
    @RequestMapping(value = ["/SelectUsers"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun selectUsers(@RequestParam(name="list", required=false, defaultValue="0") listIds:List<Int>) = userRepo.findByIdIn(listIds)
}