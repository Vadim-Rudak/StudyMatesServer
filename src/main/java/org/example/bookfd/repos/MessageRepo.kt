package org.example.bookfd.repos

import org.example.bookfd.domain.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepo : CrudRepository<Message?, Int?> {
    fun findByTagAndId(tag: String?, id: Int): List<Message?>?
}

