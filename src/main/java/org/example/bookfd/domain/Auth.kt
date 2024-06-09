package org.example.bookfd.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "autoriz")
class Auth {

    @Id
    var id: Int = 0
    var active: Boolean = false
    var login: String? = null
    var password: String? = null
    var role: String? = null

    override fun toString(): String {
        return "Auth{" +
                "id=" + id +
                ", active=" + active +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}'
    }
}
