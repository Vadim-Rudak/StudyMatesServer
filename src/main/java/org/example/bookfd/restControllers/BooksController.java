package org.example.bookfd.restControllers;

import org.example.bookfd.domain.AllNamesBooks;
import org.example.bookfd.domain.Books;
import org.example.bookfd.domain.Questions;
import org.example.bookfd.domain.Results;
import org.example.bookfd.repos.AllNamesBooksRepo;
import org.example.bookfd.repos.BooksRepo;
import org.example.bookfd.repos.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RestController
public class BooksController {


    @Autowired
    private AllNamesBooksRepo allNamesBooksRepo;

    @Autowired
    private BooksRepo booksRepo;

    @RequestMapping(value = "/Books", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<?> ms2(@RequestParam(name="id", required=false, defaultValue="11") int id_book, Model model) {
//        Message ms = new Message();
//        ms.setId(54);
//        ms.setText("gygygndj2");
//        ms.setTag("gygyg");
        Books book = booksRepo.findByIdbook(id_book);

        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(Base64.getMimeDecoder().decode(book.getResbook()));
    }

    public static String decodeString(String encodeText) throws UnsupportedEncodingException {
        byte[] decoded = Base64.getMimeDecoder().decode(encodeText);
        String output = new String(decoded);
        return output;
    }

    @PostMapping ("/AddNewBook")
    public ResponseEntity<?> addNewBook(@RequestParam(name="numclass", required=false, defaultValue="-1") int num_class,
                                         @RequestParam(name="namebook", required=false, defaultValue="-1") String name_book,
                                            @RequestParam("resbook") MultipartFile file) {
        Books bk = new Books();
        AllNamesBooks bk2 = new AllNamesBooks();
        bk.setNamebook(name_book);
        bk.setNumclass(num_class);
        bk2.setNamebook(name_book);
        bk2.setNumclass(num_class);
        try {
            bk.setResbook(encodeString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        allNamesBooksRepo.save(bk2);
        bk.setIdbook(bk2.getId());
        booksRepo.save(bk);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/GetIdBook", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getIdBook(@RequestParam(name="num_class", required=false, defaultValue="11") int num_class, @RequestParam(name="name_book", required=false, defaultValue="Физика") String name_book, Model model) {
        Books book = booksRepo.findByNamebookAndNumclass(name_book,num_class);
        return book.getID();
    }

    @PostMapping("/up_book")
    public ResponseEntity<?> up_book(@RequestBody Books books)
    {
        System.out.println(books.getID());
        int id = books.getID();
        Books book_copy = booksRepo.findByID(id);
        book_copy.setResbook(book_copy.getResbook()+books.getResbook());
        book_copy.setID(id);
        booksRepo.save(book_copy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }

}
