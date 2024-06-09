package org.example.bookfd.restControllers.auth

import org.example.bookfd.domain.Authoriz
import org.example.bookfd.domain.UserMod
import org.example.bookfd.repos.AuthRepo
import org.example.bookfd.repos.PhotoRepo
import org.example.bookfd.repos.SchoolRepo
import org.example.bookfd.repos.UserRepo
import org.example.bookfd.ID_USER
import org.example.bookfd.webSocket.MyHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.TextMessage

@RestController
class LoginRestController (
    @Autowired private val myHandler: MyHandler,
    @Autowired private val authRepo: AuthRepo,
    @Autowired private val userRepo: UserRepo,
    @Autowired private val schoolRepo: SchoolRepo,
    @Autowired private val photoRepo: PhotoRepo
) {

    /*
        Rest auth get user information
    */

    @GetMapping(value = ["/authoriz"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addNewUser(authentication: Authentication): Authoriz {
        if (authentication!=null){

            val authFind = authRepo.findByLogin(authentication.name)
            ID_USER = authFind!!.id
            val userMod = UserMod().apply {
                setUser(userRepo.findById(ID_USER)!!)
                auth = authFind
                school = schoolRepo.findById(ID_USER)
                photo = photoRepo.findById(ID_USER)
            }
            myHandler.sendMessageToUser(ID_USER, TextMessage("UpdateInfoChat"))

            return Authoriz(true, "Авторизация прошла успешно", userMod)
        }else{
            return Authoriz(false, "Ошибка, не верный логин либо пароль", null)
        }
    }
}