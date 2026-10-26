package com.hardwarepos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Label label = new Label("Hardware Store POS");
		StackPane root = new StackPane(label);
		Scene scene = new Scene(root, 800, 600);

		stage.setTitle("Hardware Store POS");
		stage.setScene(scene);
		stage.show();
	}
}