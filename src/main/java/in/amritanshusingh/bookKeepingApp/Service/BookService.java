package in.amritanshusingh.bookKeepingApp.Service;

import in.amritanshusingh.bookKeepingApp.Model.Book;
import in.amritanshusingh.bookKeepingApp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public String save(Book book) throws SQLException {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookRepository.getAllBooks();
    }

    public Book getBookWithId(int id) throws SQLException {
        return bookRepository.getBookWithId(id);
    }

    public String createTable(String table_name) throws SQLException {
        return bookRepository.createTable(table_name);
    }
}
