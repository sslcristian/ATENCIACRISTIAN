module javaFXProject {
	requires javafx.controls;
	requires javafx.fxml;
	opens controller;
	opens application to javafx.graphics, javafx.fxml;
}
