package org.example.bookfd.repos

import org.example.bookfd.domain.AllNamesBooks
import org.springframework.data.repository.CrudRepository

interface AllNamesBooksRepo : CrudRepository<AllNamesBooks?, Int?> {
    fun findByNumclass(numclass: Int): List<AllNamesBooks?>?
    fun findByNumclassAndNamebook(num: Int, namebook: String?): AllNamesBooks?
    fun findById(id: Int): AllNamesBooks?
}
