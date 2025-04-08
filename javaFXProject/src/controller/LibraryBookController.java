package controller;
import java.sql.Connection;

import application.Main;
import data.BookDAO;
import data.DB_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control. TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;

public class LibraryBookController {

    @FXML
    private TableView<Book> Table;
    
    @FXML
    private Button Back;
    @FXML
    private Button btborrar;

    @FXML
    private Button btnMenuP;
    @FXML
    private TableColumn<Book, String> Author;
	
	@FXML
	private TableColumn<Book, String> Title;
	
	@FXML
	private TableColumn<Book, Long> isbn;
	
	@FXML
	private TableColumn<Book, Integer> year;
    private Connection dbConnection = DB_connection.getInstance().getConnection();
    private BookDAO bookDAO = new BookDAO(dbConnection);
	@FXML
	
	public void initialize() {
		ObservableList<Book> books = FXCollections.observableArrayList();
		
		for(Book book:bookDAO.fetch()){ 
			if(book.isDisponible()) { 
			books.add(book);
			}
		}
		// Bind the columns
		Title.setCellValueFactory (new PropertyValueFactory<>("titulo"));
		Author.setCellValueFactory (new PropertyValueFactory<>("autor"));
		isbn.setCellValueFactory (new PropertyValueFactory<>("ISBN"));
		year.setCellValueFactory (new PropertyValueFactory<>("año"));
		
		// Set the data in the TableView
		Table.setItems (books);
		}

    @FXML
    void goBack(ActionEvent event) {
    	Main.loadScene("/view/MenuBook.fxml");
    }

    @FXML
    void goToMainMenu(ActionEvent event) {
    	Main.loadScene("/view/MenuPrincipal.fxml");
    }
    @FXML
    void borrarLibro(ActionEvent event) {
    	Book book = Table.getSelectionModel().getSelectedItem();
    	bookDAO.delete(book.getISBN());
    	initialize();
    }
    
}

