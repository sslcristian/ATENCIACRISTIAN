package controller;

import application.Main;
import data.UserDataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import model.User;
import model.User;

public class RegistroController {

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnMenuP;
    
    private UserDataManager userManager = UserDataManager.getInstance();

    @FXML
    void registrarUsuario() {
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String contraseña = txtContraseña.getText().trim();

        if (nombreUsuario.isEmpty() || contraseña.isEmpty()) {
            mostrarAlerta("Error", "Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }

        // Crear un nuevo usuario y agregarlo a la lista de registrados
        User nuevoUsuario = new User(nombreUsuario, contraseña);
        userManager.addUser(nuevoUsuario);

        mostrarAlerta("Éxito", "Usuario registrado", "El usuario se ha registrado correctamente.");
        limpiarCampos();
    }

    @FXML
    void goToMainMenu() {
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
        txtNombreUsuario.clear();
        txtContraseña.clear();
    }
}