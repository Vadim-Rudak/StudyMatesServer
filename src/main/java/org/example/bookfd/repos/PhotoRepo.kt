package org.example.bookfd.repos

import org.example.bookfd.domain.Photo
import org.springframework.data.jpa.repository.JpaRepository

interface PhotoRepo : JpaRepository<Photo?, Long?> {
    fun findById(id: Int): Photo?
}
