package in.amritanshusingh.bookKeepingApp.Controller;

import in.amritanshusingh.bookKeepingApp.Model.Book;
import in.amritanshusingh.bookKeepingApp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book) throws SQLException {
        return bookService.save(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBook() throws SQLException {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBook")
    public Book getBookWithId(@RequestParam(value = "id") int id) throws SQLException {
        return bookService.getBookWithId(id);
    }

    @PostMapping("/createTable/{table_name}")
    public String createTable(@PathVariable String table_name) throws SQLException {
        return bookService.createTable(table_name);
    }
}