package org.example.bookfd;

import org.example.bookfd.domain.AllNamesBooks;
import org.example.bookfd.domain.BookUp;
import org.example.bookfd.domain.Books;
import org.example.bookfd.domain.Questions;
import org.example.bookfd.repos.AllNamesBooksRepo;
import org.example.bookfd.repos.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class BookPageController {

    @Autowired
    private AllNamesBooksRepo allNamesBooksRepo;

    @Autowired
    private BooksRepo booksRepo;

    @RequestMapping(value = "/PageBooks",produces = MediaType.IMAGE_PNG_VALUE)
    public String greeting1(@RequestParam(name="num_class", required=false, defaultValue="11") int num_class, Map<String, Object> model) {
//        String name_s = null;
//        try {
//            name_s = decodeString(name_sub);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        Iterable<TestsNames> tests = TestsNamesRepo.findBySubjectAndNumclass(name_s,num_class);
//        model.put("tests", tests);
//        model.put("name_sub", name_sub);
        Iterable<AllNamesBooks> books = allNamesBooksRepo.findByNumclass(num_class);
        model.put("books",books);
        model.put("num_cl",num_class);
        return "BooksPage";
    }

    @GetMapping("/add_book")
    public String addbook(@RequestParam(name="num_class") String num_class,Map<String, Object> model){
        model.put("num_cl",num_class);
        return "AddBook";
    }

    @PostMapping("/add_FileBook")
    public String create(@RequestParam(name="num_cl") String num_cl,
                         @RequestParam(name="name_sub") String name_sub,
                         @RequestParam(name="num_class") String num_class,
                         @RequestParam("image_file") MultipartFile image_file,
                         @RequestParam("file") MultipartFile res_book, Map<String, Object> model) {
        model.put("num_cl",num_cl);
        if (name_sub.equals("")||num_class.equals("")||image_file.getSize()==0||res_book.getSize()==0){
            if (name_sub.equals("")){
                model.put("name_subError","Заполните поле");
            }else {
                model.put("name_sub",name_sub);
            }
            if (num_class.equals("")){
                model.put("num_classError","Заполните поле");
            }else {
                if (Integer.parseInt(num_class)<=0||Integer.parseInt(num_class)>11){
                    model.put("num_classError","Заполните поле в диапазоне от 1 до 11");
                }else{
                    model.put("num_class",num_class);
                }
            }
            if (image_file.getSize()==0){
                model.put("image_fileError","Добавьте файл");
            }else {
                model.put("image_fileError","Добавьте файл");
            }
            if (res_book.getSize()==0){
                model.put("res_bookError","Добавьте файл");
            }else {
                model.put("res_bookError","Добавьте файл");
            }
            return "AddBook";
        }else {
            if (Integer.parseInt(num_class)<=0||Integer.parseInt(num_class)>11){
                model.put("name_sub",name_sub);
                model.put("num_classError","Заполните поле в диапазоне от 1 до 11");
                return "AddBook";
            }else {
                List<Books> ds = booksRepo.findByNumclassAndNamebook(Integer.parseInt(num_class),name_sub);
                if (ds.size()!=0){
                    model.put("name_subError","Заполните поле заново");
                    model.put("num_classError","Заполните поле заново");
                    return "AddBook";
                }{
                    Books book = new Books();
                    book.setNamebook(name_sub);
                    book.setNumclass(Integer.parseInt(num_class));
                    AllNamesBooks allNamesBooks = new AllNamesBooks();
                    allNamesBooks.setNamebook(name_sub);
                    allNamesBooks.setNumclass(Integer.parseInt(num_class));
                    try {
                        book.setResbook(encodeString(res_book.getBytes()));
                        allNamesBooks.setImagebook(encodeString(image_file.getBytes()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    allNamesBooksRepo.save(allNamesBooks);
                    book.setIdbook(allNamesBooks.getId());
                    booksRepo.save(book);

                    return "redirect:/PageBooks";
                }
            }
        }
    }

    @GetMapping("/delete_book")
    public String addquest(@RequestParam(name="id_book", required=false, defaultValue="-1") int id_book,@RequestParam(name="num_class", required=false, defaultValue="-1") int num_class, Map<String, Object> model){
        allNamesBooksRepo.deleteById(id_book);
        return "redirect:/PageBooks?num_class=" + num_class;
    }

    @RequestMapping("/UpdateBook")
    public String UpBook1(@RequestParam(name="id_book", required=false, defaultValue="-1") int id_book,
                             @RequestParam(name="num_class", required=false, defaultValue="-1") int num_class,
                             Map<String, Object> model) {

        AllNamesBooks allNamesBooks = allNamesBooksRepo.findById(id_book);
        model.put("book",allNamesBooks);
        return "UpBook";
    }

    @RequestMapping("/AddNewFile")
    public String AddNewFile(@RequestParam(name="id_book", required=false, defaultValue="-1") int id_book,
                          Map<String, Object> model) {
        model.put("id_book",id_book);
        return "addBookFile";
    }

    @RequestMapping("/AddNewFile2")
    public String AddNewFile2(@RequestParam(name="id_book", required=false, defaultValue="-1") int id_book,
                              @RequestParam("file") MultipartFile file,
                             Map<String, Object> model) {
        if (file.getSize()==0){
            model.put("id_book",id_book);
            model.put("error","Выберите файл");
            return "addBookFile";
        }else {
            Books bk = booksRepo.findByIdbook(id_book);
            try {
                bk.setResbook(encodeString(file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            booksRepo.save(bk);
            return "redirect:/PageBooks?num_class=" + bk.getNumclass();
        }
    }

    @RequestMapping("/AddNewImage")
    public String AddNewImage(@RequestParam(name="id_book", required=false, defaultValue="-1") int id_book,
                          Map<String, Object> model) {
        model.put("id_book",id_book);
        return "AddBookImage";
    }

    @RequestMapping("/AddNewImage2")
    public String AddNewImage2(@RequestParam(name="id_book", required=false, defaultValue="-1") int id_book,
                               @RequestParam("image_file") MultipartFile image_file,
                              Map<String, Object> model) {
        if (image_file.getSize()==0){
            model.put("id_book",id_book);
            model.put("error","Выберите файл");
            return "AddBookImage";
        }else {
            AllNamesBooks bk2 = allNamesBooksRepo.findById(id_book);
            try {
                bk2.setImagebook(encodeString(image_file.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            allNamesBooksRepo.save(bk2);

            return "redirect:/PageBooks?num_class=" + bk2.getNumclass();
        }
    }


    @RequestMapping("/UpInfBook")
    public String UpBook(@ModelAttribute("inf_book")BookUp bookUp, Map<String, Object> model) {
        if (bookUp.getNamebook().equals("")||bookUp.getNumclass().equals("")){
            model.put("id",bookUp.getId());
            model.put("imagebook",bookUp.getImagebook());
            if (bookUp.getNamebook().equals("")){
                model.put("namebookError","Заполните поле");
            }else{
                model.put("namebook",bookUp.getNamebook());
            }
            if (bookUp.getNumclass().equals("")){
                model.put("numclassError","Заполните поле");
            }else{
                if (Integer.parseInt(bookUp.getNumclass())<=0||Integer.parseInt(bookUp.getNumclass())>11){
                    model.put("numclassError","Заполните поле в диапазоне от 1 до 11");
                }else{
                    model.put("numclass",bookUp.getNumclass());
                }
            }
            return "UpBook2";
        }else{
            if (Integer.parseInt(bookUp.getNumclass())<=0||Integer.parseInt(bookUp.getNumclass())>11){
                model.put("id",bookUp.getId());
                model.put("imagebook",bookUp.getImagebook());
                model.put("namebook",bookUp.getNamebook());
                model.put("numclassError","Заполните поле в диапазоне от 1 до 11");
                return "UpBook2";
            }else{
                int id = bookUp.getId();
                Books bk = booksRepo.findByIdbook(id);
                AllNamesBooks bk2 = allNamesBooksRepo.findById(id);
                bk.setNumclass(Integer.parseInt(bookUp.getNumclass()));
                bk.setNamebook(bookUp.getNamebook());
                bk2.setNamebook(bookUp.getNamebook());
                bk2.setNumclass(Integer.parseInt(bookUp.getNumclass()));
                booksRepo.save(bk);
                allNamesBooksRepo.save(bk2);
                return "redirect:/PageBooks?num_class=" + bookUp.getNumclass();
            }
        }
    }

//    public class ImageUtil {
//        public String getImgData(byte[] byteData) {
//            return Base64.getMimeEncoder().encodeToString(byteData);
//        }
//    }

    public static String decodeString(String encodeText) throws UnsupportedEncodingException {
        byte[] decoded = Base64.getMimeDecoder().decode(encodeText);
        String output = new String(decoded);
        return output;
    }

    private Map<String, String> getErrorsMap(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        );
        Map<String, String> errorsMap = bindingResult.getFieldErrors().stream().collect(collector);
        return errorsMap;
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }
}
