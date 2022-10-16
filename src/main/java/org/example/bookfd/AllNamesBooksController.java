package org.example.bookfd;

import org.example.bookfd.domain.AllNamesBooks;
import org.example.bookfd.repos.AllNamesBooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AllNamesBooksController {

    @Autowired
    private AllNamesBooksRepo allNamesBooksRepo;
    //(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model)
    @RequestMapping(value = "/AllBooks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object ms2(Map<String, Object> model) {
//        Message ms = new Message();
//        ms.setId(54);
//        ms.setText("gygygndj2");
//        ms.setTag("gygyg");
//        allNamesBooksRepo.save(new AllNamesBooks(14,11,"Химия","ssss"));
        Iterable<AllNamesBooks> booksw = allNamesBooksRepo.findAll();
        return booksw;
    }
//временно, метод для добавления книги
//    @PostMapping("/xv")
//    public ResponseEntity<?> create(@RequestBody AllNamesBooks allNamesBooks)
//    {
////        int d = allNamesBooks.getId();
//        allNamesBooksRepo.save(new AllNamesBooks(allNamesBooks.getId(),allNamesBooks.getNumclass(),allNamesBooks.getNamebook(),allNamesBooks.getImagebook()));
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
