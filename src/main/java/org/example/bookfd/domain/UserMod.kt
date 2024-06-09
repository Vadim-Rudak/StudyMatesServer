package org.example.bookfd.domain

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class UserMod : User() {
    var auth: Auth? = null
    var school: School? = null
    var photo: Photo? = null

    fun setUser(user: User) {
        id = user.id
        name = user.name
        lastName = user.lastName
        gender = user.gender
        dateBirthday = user.dateBirthday
        cityLive = user.cityLive
    }

    override fun toString(): String {
        return "UserMod{" +
                "auth=" + auth +
                ", school=" + school +
                ", photo=" + photo +
                '}'
    }
}
