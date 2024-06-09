package org.example.bookfd.repos

import org.example.bookfd.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User?, Int?> {
    fun findById(id: Int): User?
    fun findByIdIn(listUsersId: List<Int?>?): List<User?>?
}
