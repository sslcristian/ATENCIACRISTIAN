package data;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Book;
import model.User;

public class BookDataManager {
    private static BookDataManager instance;
    private ArrayList<Book> bookList = new ArrayList<>();
    private static OracleDBConnection dbManager = new OracleDBConnection();


    public static BookDataManager getInstance() {
        if (instance == null) {
            instance = new BookDataManager();
        }
        return instance;
    }

    public ArrayList<Book> getBooks() {
        if (bookList.isEmpty()) {
        	getBooksFromDatabase();  // Load from database if list is empty
        }
        return bookList;
    }


    private void getBooksFromDatabase() {
        try {
            ArrayList<Book> booksFromDb = dbManager.fetchBooks();
            bookList.clear();
            bookList.addAll(booksFromDb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // This method was modified to incorporate 
    public void addBook(Book book) {
    	try {
            bookList.add(book);
            dbManager.insertBook(book);
        	 } catch (SQLException e) {
                 e.printStackTrace();
             }
    }
}
