package org.example.bookfd.restControllers.auth

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.bookfd.domain.User
import org.example.bookfd.domain.UserMod
import org.example.bookfd.repos.AuthRepo
import org.example.bookfd.repos.PhotoRepo
import org.example.bookfd.repos.SchoolRepo
import org.example.bookfd.repos.UserRepo
import org.example.bookfd.response.Registration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
class RegRestController @Autowired constructor(
    private val userRepo: UserRepo,
    private val authRepo: AuthRepo,
    private val photoRepo: PhotoRepo,
    private val schoolRepo: SchoolRepo
) {

    private fun encodeString(bytes: ByteArray?) = Base64.getEncoder().encodeToString(bytes)

    /*
        Registration user in app
    */
    @PostMapping(value = ["/registration_mobile"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun registrationInClient(
        @RequestParam(name="user", required=false, defaultValue="-1") userJSON:String,
        @RequestParam("user_photo") filePhoto: MultipartFile
    ):Registration{
        val userMod = ObjectMapper().readValue(userJSON,UserMod::class.java)

        val user = User().apply {
            name = userMod.name
            gender = userMod.gender
            cityLive = userMod.cityLive
            lastName = userMod.lastName
            dateBirthday = userMod.dateBirthday
        }
        userRepo.save(user)

        authRepo.save(userMod.auth?.apply { id = user.id }!!)
        photoRepo.save(userMod.photo?.apply {
            id = user.id
            res = encodeString(filePhoto.bytes)
        }!!)
        schoolRepo.save(userMod.school?.apply { id = user.id }!!)
        userMod.id = user.id

        return Registration(true,"Заполните поля",userMod)
    }

}