package controller;

import application.Main;
import data.ArticleDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.Article;
import model.Book;
public class ArticleController {


    @FXML
    private Button btnMenup;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btonimprimir;

    @FXML
    private CheckBox chkAvailability;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtISSN;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtYear;
    
    private ArticleDataManager articleManager = ArticleDataManager.getInstance();

    @FXML
    void goToMainMenu(ActionEvent event) {
    	Main.loadScene("/view/MenuPrincipal.fxml");
    }
    private void mostrarAlerta(String titulo, String cabecera, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void limpiarCampos() {
        txtTitle.clear();
        txtAuthor.clear();
        txtYear.clear();
        txtISSN.clear();
        chkAvailability.setSelected(false);
    }


    @FXML
    void imprimirArt(ActionEvent event) {
    	Main.loadScene("/view/LibraryArticle.fxml");
    }

    @FXML
    void registerAArticle(ActionEvent event) {
    	String titulo = txtTitle.getText().trim();
        String autor = txtAuthor.getText().trim();
        String añoStr = txtYear.getText().trim();
        String issnStr = txtISSN.getText().trim();
        boolean disponible = chkAvailability.isSelected();

        if (titulo.isEmpty() || autor.isEmpty() || añoStr.isEmpty() || issnStr.isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }

        try {
            long ISSN = Long.parseLong(issnStr);
            int año = Integer.parseInt(añoStr);

            if (!Article.validarISSN(ISSN)) {
                mostrarAlerta("Error", "ISBN inválido", "El ISSN debe tener 8 digitos ");
                return;
            }

    
            for (Article article : articleManager.getArticles()) {
                if (article.getISSN() == ISSN) {
                    mostrarAlerta("Error", "ISBN repetido", "El ISBN ya está registrado.");
                    return;
                }
            }

          
          Article article = new Article(titulo, autor, ISSN, año, disponible);
          articleManager.addArticle(article);
            mostrarAlerta("Éxito", "Article registrado", "El libro se ha registrado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Formato inválido", "El año y el ISBN deben ser números válidos.");
        }
    }

}
