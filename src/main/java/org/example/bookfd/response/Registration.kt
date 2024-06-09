package org.example.bookfd.response

import org.example.bookfd.domain.User

class Registration() {
    var status_reg: Boolean? = null
    var message: String? = null
    var user: User? = null

    constructor(status_reg: Boolean?, message: String?, user: User?) : this() {
        this.status_reg = status_reg
        this.message = message
        this.user = user
    }
}