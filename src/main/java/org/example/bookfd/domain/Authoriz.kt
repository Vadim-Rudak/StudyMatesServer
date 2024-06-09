package org.example.bookfd.domain

class Authoriz {

    var status: Boolean? = null
    var message: String? = null
    var userMod: UserMod? = null

    constructor(status: Boolean?, message: String?, userMod: UserMod?) {
        this.status = status
        this.message = message
        this.userMod = userMod
    }
}
