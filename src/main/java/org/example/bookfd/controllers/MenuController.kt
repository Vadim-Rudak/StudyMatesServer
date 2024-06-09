package org.example.bookfd.controllers

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MenuController {

    @GetMapping("/")
    fun start(model: MutableMap<String?, Any?>, authentication: Authentication): String {
        model["userstatus"] = authentication.authorities
        return "menu/TopMenu"
    }

    @GetMapping("/menu")
    fun menu(): String {
        return "menu"
    }
}