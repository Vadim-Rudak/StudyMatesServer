package org.example.bookfd.repos

import org.example.bookfd.domain.Questions
import org.springframework.data.repository.CrudRepository

interface QuestionsRepo : CrudRepository<Questions?, Int?> {
    fun findById(id: Int): Questions?
    fun findByTestid(testid: Int): List<Questions?>?
}
