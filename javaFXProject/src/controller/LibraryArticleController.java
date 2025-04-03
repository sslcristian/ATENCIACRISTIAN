package controller;

import application.Main;
import data.ArticleDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control. TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Article;

public class LibraryArticleController {

    @FXML
    private TableView<Article> TableA;
    
    @FXML
    private Button Back;

    @FXML
    private Button btnMenuP;
    
    @FXML
    private TableColumn<Article, String> Author;
	
	@FXML
	private TableColumn<Article, String> Title;
	
	@FXML
	private TableColumn<Article, Long> issn;
	
	@FXML
	private TableColumn<Article, Integer> year;
	private ArticleDataManager articleManager = ArticleDataManager.getInstance();
	@FXML
	
	public void initialize() {
		ObservableList<Article> articles = FXCollections.observableArrayList();
		
		for(Article article:articleManager.getArticles()){ 
			if(article.isAvailability()) { 
			articles.add(article);
			}
		}
		// Bind the columns
		Title.setCellValueFactory (new PropertyValueFactory<>("titulo"));
		Author.setCellValueFactory (new PropertyValueFactory<>("autor"));
		issn.setCellValueFactory (new PropertyValueFactory<>("ISSN"));
		year.setCellValueFactory (new PropertyValueFactory<>("año"));
		
		// Set the data in the TableView
		TableA.setItems (articles);
		}

    @FXML
    void goBack(ActionEvent event) {
    	Main.loadScene("/view/MenuBook.fxml");
    }

    @FXML
    void goToMainMenu(ActionEvent event) {
    	Main.loadScene("/view/MenuPrincipal.fxml");
    }
    
}

