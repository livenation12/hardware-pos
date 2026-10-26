package com.hardwarepos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private VBox buildCartPanel() {
		TableView<Object> cartTable = new TableView<>();
		cartTable.getColumns().add(new TableColumn<>("Item"));
		cartTable.getColumns().add(new TableColumn<>("Qty"));
		cartTable.getColumns().add(new TableColumn<>("Unit Price"));
		cartTable.getColumns().add(new TableColumn<>("Line Total"));
		cartTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
		cartTable.setPlaceholder(new Label("Cart is empty"));
		VBox.setVgrow(cartTable, Priority.ALWAYS);

		VBox panel = new VBox(10, new Label("Current Sale"), cartTable);
		panel.setPadding(new Insets(12));
		return panel;
	}

	private HBox buildFooter() {
		Label totalLabel = new Label("Total: \u20B10.00");
		totalLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

		Region spacer = new Region();
		HBox.setHgrow(spacer, Priority.ALWAYS);

		Button clearButton = new Button("Clear Cart");
		Button payButton = new Button("Pay (Cash)");

		HBox footer = new HBox(12, totalLabel, spacer, clearButton, payButton);
		footer.setAlignment(Pos.CENTER_LEFT);
		footer.setPadding(new Insets(12));
		footer.setStyle("-fx-background-color: #e8e8e8;");
		return footer;
	}

	private HBox buildHeader() {
		Label title = new Label("Hardware Store POS");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

		HBox header = new HBox(title);
		header.setPadding(new Insets(12));
		header.setStyle("-fx-background-color: #e8e8e8;");
		return header;
	}

	private VBox buildProductPanel() {
		TextField searchField = new TextField();
		searchField.setPromptText("Search name, SKU or barcode");

		ListView<String> productList = new ListView<>();
		productList.getItems().addAll("Sample product 1", "Sample product 2", "Sample product 3");
		VBox.setVgrow(productList, Priority.ALWAYS);

		VBox panel = new VBox(10, new Label("Products"), searchField, productList);
		panel.setPadding(new Insets(12));
		panel.setPrefWidth(360);
		return panel;
	}

	@Override
	public void init() {
		System.out.println("init() on thread: " + Thread.currentThread().getName());
	}

	@Override
	public void start(Stage stage) {
		System.out.println("start() on thread: " + Thread.currentThread().getName());

		BorderPane root = new BorderPane();
		root.setTop(buildHeader());
		root.setLeft(buildProductPanel());
		root.setCenter(buildCartPanel());
		root.setBottom(buildFooter());

		Scene scene = new Scene(root, 1100, 700);
		stage.setTitle("Hardware Store POS");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() {
		System.out.println("stop() called - application closing");
	}
}