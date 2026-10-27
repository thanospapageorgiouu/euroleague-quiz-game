package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameCreationView {

	private Scene scene;

	public GameCreationView(Stage stage) {

		// Title
		Label title = new Label("Create New Game");

		// Player names
		Label namePromptPlayer1 = new Label("Player 1 Name:");
		Label namePromptPlayer2 = new Label("Player 2 Name:");

		TextField player1NameField = new TextField();
		TextField player2NameField = new TextField();

		player1NameField.setPromptText("Enter player 1 name");
		player2NameField.setPromptText("Enter player 2 name");

		player1NameField.setMaxWidth(220);
		player2NameField.setMaxWidth(220);

		VBox player1Box = new VBox(10,
				namePromptPlayer1,
				player1NameField
		);

		VBox player2Box = new VBox(10,
				namePromptPlayer2,
				player2NameField
		);

		player1Box.setAlignment(Pos.CENTER);
		player2Box.setAlignment(Pos.CENTER);

		HBox playersBox = new HBox(80, player1Box, player2Box);
		playersBox.setAlignment(Pos.CENTER);

		// Game mode selection
		Label chooseModeLabel = new Label("Choose your game mode:");

		ToggleGroup gameModeGroup = new ToggleGroup();

		RadioButton sixCategoriesButton =
				new RadioButton("6 Categories");

		RadioButton eightCategoriesButton =
				new RadioButton("8 Categories - Coming Soon");

		RadioButton tenCategoriesButton =
				new RadioButton("10 Categories - Coming Soon");

		sixCategoriesButton.setToggleGroup(gameModeGroup);
		eightCategoriesButton.setToggleGroup(gameModeGroup);
		tenCategoriesButton.setToggleGroup(gameModeGroup);

		sixCategoriesButton.setSelected(true);

		eightCategoriesButton.setDisable(true);
		tenCategoriesButton.setDisable(true);

		VBox gameModesBox = new VBox(15,
				chooseModeLabel,
				sixCategoriesButton,
				eightCategoriesButton,
				tenCategoriesButton
		);

		gameModesBox.setAlignment(Pos.CENTER_LEFT);

		// Buttons
		Button startButton = new Button("Start Game");
		Button backButton = new Button("Back");

		startButton.setPrefWidth(200);
		backButton.setPrefWidth(200);

		// Main layout
		VBox layout = new VBox(30,
				title,
				playersBox,
				gameModesBox,
				startButton,
				backButton
		);

		layout.setAlignment(Pos.CENTER);
		layout.setStyle("-fx-background-color: #1a1a1a;");

		// Styling
		title.setStyle(
				"-fx-font-size: 36px;" +
						"-fx-font-weight: bold;" +
						"-fx-text-fill: white;"
		);

		namePromptPlayer1.setStyle(
				"-fx-font-size: 20px;" +
						"-fx-text-fill: white;"
		);

		namePromptPlayer2.setStyle(
				"-fx-font-size: 20px;" +
						"-fx-text-fill: white;"
		);

		chooseModeLabel.setStyle(
				"-fx-font-size: 22px;" +
						"-fx-text-fill: white;"
		);

		sixCategoriesButton.setStyle(
				"-fx-font-size: 16px;" +
						"-fx-text-fill: white;"
		);

		eightCategoriesButton.setStyle(
				"-fx-font-size: 16px;" +
						"-fx-text-fill: #888888;"
		);

		tenCategoriesButton.setStyle(
				"-fx-font-size: 16px;" +
						"-fx-text-fill: #888888;"
		);

		startButton.setStyle(
				"-fx-background-color: #ff6b00;" +
						"-fx-text-fill: white;" +
						"-fx-font-size: 18px;" +
						"-fx-font-weight: bold;"
		);

		backButton.setStyle(
				"-fx-background-color: #444444;" +
						"-fx-text-fill: white;" +
						"-fx-font-size: 18px;"
		);

		startButton.setOnAction(event -> {
			String name1 = player1NameField.getText().trim();
			String name2 = player2NameField.getText().trim();
			if (name1.isEmpty()){
				name1 = "Player 1";
			}
			if (name2.isEmpty()){
				name2 = "Player 2";
			}
			GameManager gameManager = new GameManager(name1, name2);
			BoardView boardView = new BoardView(stage, gameManager, 6);
			stage.setScene(boardView.getScene());
		});

		backButton.setOnAction(event -> {
			MainMenuView mainMenuView = new MainMenuView(stage);
			stage.setScene(mainMenuView.getScene());
		});

		// Scene
		scene = new Scene(layout, 1280, 780);
	}

	public Scene getScene() {
		return scene;
	}
}
