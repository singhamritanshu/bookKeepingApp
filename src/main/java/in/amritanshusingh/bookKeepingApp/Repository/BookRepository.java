package in.amritanshusingh.bookKeepingApp.Repository;

import in.amritanshusingh.bookKeepingApp.Model.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private String tableName = "myBook";
    private Connection connection;
    private void getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","Ind-0542");
        }
    }

    private void closeConnection(){
        connection = null;
    }

    public String createTable(String table_name) throws SQLException {
        getConnection();
        this.tableName = table_name;
        Statement statement = connection.createStatement();
        boolean isSuccess = statement.execute("CREATE TABLE "+ this.tableName + "(id INT primary key, book_name VARCHAR(20), author_name VARCHAR(30), cost INT)");
        if(isSuccess){
            System.out.println("Table "+ this.tableName+" created successfully");
        }
        else {
            System.out.println("Table with name "+ this.tableName+" not created");
        }
        //closeConnection();
        return "Table created";
    }
    public String save(Book book) throws SQLException {

        getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + this.tableName + " VALUES (?,?,?,?)");

        preparedStatement.setInt(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3,book.getAuthorName());
        preparedStatement.setInt(4,book.getCost());

        int row = preparedStatement.executeUpdate();

        if (row < 1) {

            System.out.println("Book "+book.getName()+" is not added");
            return "Book not saved successfully";
        }
        else {
            System.out.println("Book "+book.getName()+" added successfully");
            return "Book saved successfully";
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        getConnection();
        ArrayList<Book> books = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM "+this.tableName);

        while(resultSet.next()){ // .next will check if there is next object present
            int id = resultSet.getInt(1);
            String bookName = resultSet.getString(2);
            String authorName = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book = new Book(bookName,id,authorName,cost);
            books.add(book);
        }
        return books;
    }

    public Book getBookWithId(int id) throws SQLException {
        getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + this.tableName + " WHERE id = "+id);
        Book book = new Book();
        while(resultSet.next()){
            id = resultSet.getInt(1);
            String bookName = resultSet.getString(2);
            String authorName = resultSet.getString(3);
            int cost = resultSet.getInt(4);

            Book book1 = new Book(bookName,id,authorName,cost);
            book = book1;
        }
        return book;
    }
}