package data;

import java.util.ArrayList;

import model.Book;

public class BookDataManager {
    private static BookDataManager instance;
    private ArrayList<Book> bookList = new ArrayList<>();
   

    public static BookDataManager getInstance() {
        if (instance == null) {
            instance = new BookDataManager();
        }
        return instance;
    }

    public ArrayList<Book> getBooks() {
        return bookList;
    }


    
    public void addBook(Book user) {
        bookList.add(user);
    }
}
