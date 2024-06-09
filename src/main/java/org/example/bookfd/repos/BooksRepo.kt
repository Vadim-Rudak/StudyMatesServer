package org.example.bookfd.repos

import org.example.bookfd.domain.Books
import org.springframework.data.repository.CrudRepository

interface BooksRepo : CrudRepository<Books?, Int?> {
    fun findByNumclassAndNamebook(num_class: Int, name_book: String?): List<Books?>?
    fun findByNamebookAndNumclass(name_book: String?, num_class: Int): Books?
    fun findByID(ID: Int?): Books?
    fun findByIdbook(idbook: Int): Books?
}
