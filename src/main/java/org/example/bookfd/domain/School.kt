package org.example.bookfd.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "school")
class School {
    @Id
    var id = 0
    var name: String? = null
    var nameCity: String? = null
    var numClass = 0
    var endSchool: Boolean? = null

    override fun toString(): String {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameCity='" + nameCity + '\'' +
                ", numClass=" + numClass +
                ", endSchool=" + endSchool +
                '}'
    }
}
