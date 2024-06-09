package org.example.bookfd.domain

import javax.persistence.*

@Entity
@Table(name = "usr")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id:Int = 0
    open var name: String? = null
    open var lastName: String? = null
    open var gender: String? = null
    open var dateBirthday: String? = null
    open var cityLive: String? = null


    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateBirthday='" + dateBirthday + '\'' +
                ", cityLive='" + cityLive + '\'' +
                '}'
    }
}
