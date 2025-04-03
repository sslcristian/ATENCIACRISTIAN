package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegistrarController {

    @FXML
    private Button btnMenu;

    @FXML
    private Button registroarticle;

    @FXML
    private Button registrolibro;

    @FXML
    void goToMainMenuPrincipal(ActionEvent event) {
    	Main.loadScene("/view/MenuPrincipal.fxml");

    }

    @FXML
    void ingresoLibro(ActionEvent event) {
    	Main.loadScene("/view/MenuBook.fxml");

    }

    @FXML
    void registrarArticulo(ActionEvent event) {
    	Main.loadScene("/view/Articlefx.fxml");

    }

}
