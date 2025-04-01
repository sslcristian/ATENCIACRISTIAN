module javaFXProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	opens controller;
	opens application to javafx.graphics, javafx.fxml;
}
