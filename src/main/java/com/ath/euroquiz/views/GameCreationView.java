
package com.ath.euroquiz.views;

import com.ath.euroquiz.managers.GameManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

		ToggleButton sixCategoriesButton =
				new ToggleButton("6 Categories");

		ToggleButton eightCategoriesButton =
				new ToggleButton("8 Categories\nComing Soon");

		ToggleButton tenCategoriesButton =
				new ToggleButton("10 Categories\nComing Soon");

		sixCategoriesButton.setToggleGroup(gameModeGroup);
		eightCategoriesButton.setToggleGroup(gameModeGroup);
		tenCategoriesButton.setToggleGroup(gameModeGroup);

		sixCategoriesButton.setSelected(true);

		eightCategoriesButton.setDisable(true);
		tenCategoriesButton.setDisable(true);

		// Game mode cards
		HBox modesRow = new HBox(15,
				sixCategoriesButton,
				eightCategoriesButton,
				tenCategoriesButton
		);

		modesRow.setAlignment(Pos.CENTER);

		VBox gameModesBox = new VBox(20,
				chooseModeLabel,
				modesRow
		);

		gameModesBox.setAlignment(Pos.CENTER);

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

		// Initial card styling
		updateModeStyles(
				sixCategoriesButton,
				eightCategoriesButton,
				tenCategoriesButton,
				gameModeGroup.getSelectedToggle()
		);

		// Update card styles when selection changes
		gameModeGroup.selectedToggleProperty().addListener(
				(obs, oldToggle, newToggle) ->
						updateModeStyles(
								sixCategoriesButton,
								eightCategoriesButton,
								tenCategoriesButton,
								newToggle
						)
		);

		// Start Game action
		startButton.setOnAction(event -> {
			String name1 = player1NameField.getText().trim();
			String name2 = player2NameField.getText().trim();

			if (name1.isEmpty()) {
				name1 = "Player 1";
			}

			if (name2.isEmpty()) {
				name2 = "Player 2";
			}

			GameManager gameManager = new GameManager(name1, name2);
			BoardView boardView = new BoardView(stage, gameManager, 6);

			stage.setScene(boardView.getScene());
		});

		// Back action
		backButton.setOnAction(event -> {
			MainMenuView mainMenuView = new MainMenuView(stage);
			stage.setScene(mainMenuView.getScene());
		});

		// Scene
		scene = new Scene(layout, 1280, 780);
	}

	private void updateModeStyles(
			ToggleButton sixCategoriesButton,
			ToggleButton eightCategoriesButton,
			ToggleButton tenCategoriesButton,
			Toggle selectedToggle) {

		updateSingleModeStyle(
				sixCategoriesButton,
				selectedToggle == sixCategoriesButton
		);

		updateSingleModeStyle(
				eightCategoriesButton,
				selectedToggle == eightCategoriesButton
		);

		updateSingleModeStyle(
				tenCategoriesButton,
				selectedToggle == tenCategoriesButton
		);
	}

	private void updateSingleModeStyle(
			ToggleButton button,
			boolean selected) {

		String borderColor = selected ? "#ff6b00" : "#555555";
		String textColor = button.isDisabled() ? "#888888" : "white";


		button.setStyle("""
                -fx-font-size: 17px;
                -fx-padding: 25px;
                -fx-pref-width: 230px;
                -fx-pref-height: 140px;
                -fx-alignment: center;
                -fx-background-color: #2d2d2d;
                -fx-border-color: %s;
                -fx-border-width: 2px;
                -fx-text-fill: %s;
                -fx-shape: "";
                """.formatted(borderColor, textColor));
	}

	public Scene getScene() {
		return scene;
	}
}