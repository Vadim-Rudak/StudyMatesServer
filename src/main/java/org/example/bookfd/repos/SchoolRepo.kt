package org.example.bookfd.repos

import org.example.bookfd.domain.School
import org.springframework.data.jpa.repository.JpaRepository

interface SchoolRepo : JpaRepository<School?, Long?> {
    fun findById(id: Int): School?
}
