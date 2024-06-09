package org.example.bookfd.restControllers.books

import org.example.bookfd.domain.AllNamesBooks
import org.example.bookfd.domain.Books
import org.example.bookfd.repos.AllNamesBooksRepo
import org.example.bookfd.repos.BooksRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*

@RestController
class BooksRestController(
    @Autowired private val allNamesBooksRepo: AllNamesBooksRepo,
    @Autowired private val booksRepo: BooksRepo
) {

    private fun decodeString(encodeText: String?) = String(Base64.getMimeDecoder().decode(encodeText))
    private fun encodeString(bytes: ByteArray?) = Base64.getEncoder().encodeToString(bytes)

    /*
        Get json list all names books
     */
    @RequestMapping(value = ["/AllBooks"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getListAllBooks() = allNamesBooksRepo.findAll()

    /*
        Get PDF file book
     */
    @RequestMapping(value = ["/Books"], method = [RequestMethod.GET], produces = ["application/pdf"])
    fun getBookById(@RequestParam(name = "id", required = false, defaultValue = "11") bookId: Int) = ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF)
        .body(decodeString(booksRepo.findByIdbook(bookId)?.resbook))

    /*
        Add new book
    */
    @PostMapping("/AddNewBook")
    fun addNewBook(
        @RequestParam(name = "numclass", required = false, defaultValue = "-1") numClass: Int,
        @RequestParam(name = "namebook", required = false, defaultValue = "-1") nameBook: String?,
        @RequestParam("resbook") file: MultipartFile
    ):ResponseEntity<*>{
        if (!file.isEmpty){
            val allNamesBooks = AllNamesBooks(numClass,nameBook)
            allNamesBooksRepo.save(allNamesBooks)
            booksRepo.save(Books(allNamesBooks.id,numClass,nameBook, encodeString(file.bytes)))
        }
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }

    /*
        Get book id by name and num class
    */
    @RequestMapping(value = ["/GetIdBook"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getIdBook(@RequestParam(name="num_class", required=false, defaultValue="11") numClass:Int, @RequestParam(name="name_book", required=false, defaultValue="Физика") nameBook:String) =
        booksRepo.findByNamebookAndNumclass(nameBook, numClass)?.id

    /*
        Update file book
    */
    @PostMapping("/up_book")
    fun updateFileBook(@RequestBody book:Books):ResponseEntity<*>{
        val copyBook = booksRepo.findByID(book.id)?.apply {
            id = book.id
            resbook = book.resbook
        }
        copyBook?.let { booksRepo.save(it) }
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }
}