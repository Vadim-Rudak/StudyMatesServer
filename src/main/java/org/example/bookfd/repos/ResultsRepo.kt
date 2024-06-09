package org.example.bookfd.repos

import org.example.bookfd.domain.Results
import org.springframework.data.repository.CrudRepository

interface ResultsRepo : CrudRepository<Results?, Int?> {
    fun findByIdtest(id_test: Int): List<Results?>?
}
