package org.example.bookfd.repos

import org.example.bookfd.domain.Auth
import org.springframework.data.jpa.repository.JpaRepository

interface AuthRepo : JpaRepository<Auth?, Long?> {
    fun findByLogin(login: String?): Auth?
}
